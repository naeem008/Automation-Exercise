package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationExcercise {

	
	 private WebDriver driver;
	public AutomationExcercise(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[10]/a/b")
	WebElement loggedInUsername;

	@FindBy(xpath = "/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")
	WebElement deleteBtn;


	public String getActualUsername() {
	    try {
	       
	        String xpath = "//ul[@class='nav navbar-nav']/li[10]/a/b";
	        WebElement usernameElement = driver.findElement(By.xpath(xpath));
	        
	      
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(usernameElement));

	       
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String username = (String) js.executeScript("return arguments[0].innerText;", usernameElement);
	        return username;

	    } catch (Exception e) {
	        System.out.println("ERROR: Could not find or get text from username element. Exception: " + e.getMessage());
	        return null;
	    }
	}
	  public void Deletebtn() {
	        try {
	            
	            String deleteButtonXPath = "//a[@href='/delete_account']";
	            
	            
	            WebElement deleteButton = driver.findElement(By.xpath(deleteButtonXPath));

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.elementToBeClickable(deleteButton));

	            
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", deleteButton);
	            
	            System.out.println("INFO: Successfully clicked on 'Delete Account' button using JavaScript Executor.");

	        } catch (Exception e) {
	            System.out.println("ERROR: Could not click on 'Delete Account' button even with JavaScript Executor.");
	            e.printStackTrace(); 
	        }
	
	  }
}
