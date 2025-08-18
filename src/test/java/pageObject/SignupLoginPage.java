package pageObject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage extends BasePage {

    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/form/input[2]")
    WebElement txtName;

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/form/input[3]")
    WebElement txtemail;

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/form/button")
    WebElement signupBtn;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/div[1]/div[1]/label/div/span/input")
    WebElement clickMRbutton;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/div[4]/input")
    WebElement password;

    @FindBy(id = "days")
    WebElement dayDropdown;

    @FindBy(id = "months")
    WebElement monthDropdown;

    @FindBy(id = "years")
    WebElement yearDropdown;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[1]/input")
    WebElement firstname;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[2]/input")
    WebElement lastname;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[3]/input")
    WebElement companyname;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[4]/input")
    WebElement address;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[7]/input")
    WebElement state;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[8]/input")
    WebElement city;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[9]/input")
    WebElement zipcode;

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/p[10]/input")
    WebElement mobilenumber;
    
    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/form/button")
    WebElement clickCreateAccountBtn;

    @FindBy(xpath = "/html/body/section/div/div/div/h2/b")
    WebElement accountcreatedmessage;

    // ✅ Account created confirmation message
    @FindBy(xpath  = "/html/body/section/div/div/div/p[1]")
    WebElement congratulationMsg;
    
    @FindBy(xpath = "/html/body/section/div/div/div/p[2]")
    WebElement congratulationmessagElement;
    
    

    public void clickname(String name) {
        txtName.sendKeys(name);
    }

    public void clickonemail(String email) {
        txtemail.sendKeys(email);
    }

    public void clickSignUp() {
        signupBtn.click();
    }

    public void selectGenderadio() {
        clickMRbutton.click();
    }

    public void inputpassword(String pwd) {
        password.sendKeys(pwd);
    }

    private WebElement waitClickable(WebElement el) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(el));
    }

    public void selectDay(String day) {
        new Select(waitClickable(dayDropdown)).selectByVisibleText(day);
    }

    public void selectMonth(String month) {
        new Select(waitClickable(monthDropdown)).selectByVisibleText(month);
    }

    public void selectYear(String year) {
        new Select(waitClickable(yearDropdown)).selectByVisibleText(year);
    }

    public void selectDOB(String day, String month, String year) {
        selectDay(day);
        selectMonth(month);
        selectYear(year);
    }

    public void firstname(String Firstname) {
        firstname.sendKeys(Firstname);
    }

    public void lasttname(String Lastname) {
        lastname.sendKeys(Lastname);
    }

    public void Companyname(String Company) {
        companyname.sendKeys(Company);
    }

    public void address(String addresss) {
        address.sendKeys(addresss);
    }

    public void state(String State) {
        state.sendKeys(State);
    }

    public void city(String City) {
        city.sendKeys(City);
    }

    public void zipcode(String Zipcode) {
        zipcode.sendKeys(Zipcode);
    }

    public void mobilenumber(String MobileNumber) {
        mobilenumber.sendKeys(MobileNumber);
    }
    
    public void clickCreateBtn()
    {
    	clickCreateAccountBtn.click();
    }

    public String AcccountMesssasge() {
    	return accountcreatedmessage.getText();
    }

    // ✅ Check if account created message is visible
    public String CongratulationMsgMessage() {
        return congratulationMsg.getText();
    }

    // ✅ Get the account created message text
    public String CongratulationmessagElement() {
        return congratulationmessagElement.getText();
    }
    
   
    
    
}
