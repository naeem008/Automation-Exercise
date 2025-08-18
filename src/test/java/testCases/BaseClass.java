package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

import utils.Log;

public class BaseClass {
	
	
	WebDriver driver;
	Faker faker = new Faker();
	
	@BeforeTest
	public void setup() {
		
		Log.info("Starting Webdriver");
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		Log.info("Got to the URL");
		driver.get("https://automationexercise.com/");
	}
	
	
	public String randomString()
	{
		String generateString = RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
}
