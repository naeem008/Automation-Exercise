package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// For clicking signup.login button
	@FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement clickSighnupLogin;

	// For Login

	@FindBy(xpath = "/html/body/section/div/div/div[1]/div/form/input[2]")
	WebElement enterLoginEmail;

	@FindBy(xpath = "/html/body/section/div/div/div[1]/div/form/input[3]")
	WebElement enterLoginPassword;

	@FindBy(xpath = "/html/body/section/div/div/div[1]/div/form/button")
	WebElement clickLoginButton;

	public void clickSignupLgin() {
		clickSighnupLogin.click();
	}

	public void enterLoginEmail(String email) {
		enterLoginEmail.sendKeys(email);
	}

	public void enterLoginPassword(String password) {
		enterLoginPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		clickLoginButton.click();
	}
}
