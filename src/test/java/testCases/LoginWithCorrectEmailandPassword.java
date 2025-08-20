package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AutomationExcercise;
import pageObject.HomePage;
import pageObject.SignupLoginPage;
import utils.ExcelUtils;

public class LoginWithCorrectEmailandPassword extends BaseClass {

	private static final Logger log = LogManager.getLogger(LoginWithCorrectEmailandPassword.class);

	@Test
	public void testLoginWithCreatedUser() throws InterruptedException {
		log.info("===== Test Start: LoginWithCorrectEmailandPassword =====");

		Map<String, String> userData = null;
		String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testData.xlsx";

		// Step 1: Read data from Excel
		try {
			log.info("Reading credentials from Excel file...");
			ExcelUtils excelUtil = new ExcelUtils(excelFilePath);
			userData = excelUtil.readData("UserData", 1); 
			log.info("Successfully read data. Email: " + userData.get("email"));

		} catch (IOException e) {
			log.error("Failed to read data from Excel file: " + e.getMessage());
			Assert.fail("Test stopped: Could not read login credentials from Excel.");
		}

		// Step 2: Perform Login
		HomePage hPage = new HomePage(driver);

		log.info("Clicking on 'Signup / Login' button.");
		hPage.clickSignupLgin(); 

		log.info("Entering credentials for login...");
		hPage.enterLoginEmail(userData.get("email"));
		hPage.enterLoginPassword(userData.get("password"));
		hPage.clickLoginButton();
		log.info("Clicked on Login button.");
		
		Thread.sleep(10000);
		AutomationExcercise accountPage = new AutomationExcercise(driver);
		
		String loggedInUser = accountPage.getActualUsername();
				 
		
		Assert.assertNotNull(loggedInUser, "Failed to get the logged-in user text. The element might not be visible.");

		String expectedUsername = userData.get("username");
				 
		log.info("Matching username...");
		log.info("Text from Webpage: [" + loggedInUser + "]");
		log.info("Username from Excel: [" + expectedUsername + "]");

		
		Assert.assertTrue(loggedInUser.contains(expectedUsername), 
		    "Username Mismatch! Expected text to contain '" + expectedUsername + "', but found '" + loggedInUser + "'.");

		log.info("Username match successful!");
				 
		accountPage.Deletebtn();
		 
	}
}
