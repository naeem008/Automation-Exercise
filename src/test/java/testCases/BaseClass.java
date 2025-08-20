package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.github.javafaker.Faker;

import utils.Log;

public class BaseClass {

	  public WebDriver driver;
	    public Faker faker = new Faker();
	    public String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/testData.xlsx";

	    // ############ @BeforeTest কে @BeforeMethod করুন ############
	    @BeforeMethod 
	    @Parameters({ "os", "browser" })
	    public void setup(String os, String br) {
	        Log.info("===== Initializing WebDriver for a new test method =====");

	        switch (br.toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver();
	                break;
	            case "firefox":
	                driver = new FirefoxDriver();
	                break;
	            default:
	                System.out.println("Invalid browser specified!");
	                return;
	        }

	        Log.info("Navigating to the URL");
	        driver.get("https://automationexercise.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    public String randomString() {
	        String generateString = RandomStringUtils.randomAlphabetic(5);
	        return generateString;
	    }
	    
	    // ############ @AfterTest কে @AfterMethod করুন ############
	    @AfterMethod
	    public void tearDown() {
	        Log.info("===== Closing browser after the test method =====");
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}