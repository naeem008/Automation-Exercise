package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SignupLoginPage;
import utils.ExcelUtils;

public class testRegisterUser extends BaseClass {

    private static final Logger log = LogManager.getLogger(testRegisterUser.class);

    @Test
    public void testRegistration() {
        log.info("===== Test Start: testRegistration =====");

        // Home -> Signup/Login
        HomePage hPage = new HomePage(driver);
        log.info("Opening Signup/Login page from HomePage");
        hPage.clickSignupLgin();

        // Signup/Login page
        SignupLoginPage sLoginPage = new SignupLoginPage(driver);

        // Random test data
        String username = randomString().toUpperCase();
        String email    = randomString() + "@example.com";
        String password = randomString() +"@31";
        log.info("Generated data -> username: {}, email: {}", username, email, username);

        // First screen: name + email + signup
        sLoginPage.clickname(username);
        sLoginPage.clickonemail(email);
        log.info("Entered name & email, clicking Sign Up");
        sLoginPage.clickSignUp();

        // Account Info
        log.info("Filling account info (gender, password, DOB)");
        sLoginPage.selectGenderadio();
        sLoginPage.inputpassword(password);
        sLoginPage.selectDOB("15", "June", "1995");

        // Address Info
        log.info("Filling address info");
        sLoginPage.firstname(faker.name().firstName());
        sLoginPage.lasttname(faker.name().lastName());
        sLoginPage.Companyname(faker.company().name());
        sLoginPage.address(faker.address().streetAddress());
        sLoginPage.state("Dhaka");
        sLoginPage.city("Dhaka");
        sLoginPage.zipcode("1200");
        sLoginPage.mobilenumber("017" + faker.number().digits(8));

        log.info("Clicking Create Account button");
        sLoginPage.clickCreateBtn();

        // check the confirmation message
        log.info("Verifying confirmation messages");
        Assert.assertEquals(sLoginPage.AcccountMesssasge(), "ACCOUNT CREATED!");
        Assert.assertEquals(sLoginPage.CongratulationMsgMessage(),
                "Congratulations! Your new account has been successfully created!");
        Assert.assertEquals(sLoginPage.CongratulationmessagElement(),
                "You can now take advantage of member privileges to enhance your online shopping experience with us.");

        log.info("All confirmation messages matched successfully ✅");
        log.info("===== Test End: testRegistration =====");
        
        log.info("!!!!!!!!!! ABOUT TO ENTER EXCEL WRITE BLOCK !!!!!!!!!!");

        try {
            log.info("!!!!!!!!!! INSIDE EXCEL WRITE BLOCK !!!!!!!!!!"); // <-- এই লগটি আসছে কি না দেখুন
            
            String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testData.xlsx";
            ExcelUtils excelUtil = new ExcelUtils(excelFilePath);
            excelUtil.writeData("UserData", 1, username, email, password);
            log.info("Successfully wrote user credentials to Excel file.");
        } catch (IOException e) {
            log.error("Failed to write to Excel file: " + e.getMessage());
            Assert.fail("Test failed because it could not write data to the Excel file.");
        }
    }

    
}
