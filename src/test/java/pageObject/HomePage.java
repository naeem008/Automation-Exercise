package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "/html/body/header/div/div/div/div[2]/div/ul/li[4]/a")
	WebElement clickSighnupLogin;

	public void clickSignupLgin() {
		clickSighnupLogin.click();
	}

}
