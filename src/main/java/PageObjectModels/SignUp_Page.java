package PageObjectModels;

import AbstractComponent.Reusable_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUp_Page extends Reusable_Class {
    WebDriver driver;
    public SignUp_Page(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(partialLinkText = "Login")
    WebElement signUpAcountDeletePage;
    @FindBy(css="input[data-qa='signup-name']")
    WebElement name;
    @FindBy(css="input[data-qa='signup-email']")
    WebElement emailId;
    @FindBy(css="button[data-qa='signup-button']")
    WebElement signUpButton;
    @FindBy(xpath = "//b[text()='Enter Account Information']")
    WebElement accountInfoText;
    @FindBy(id = "id_gender2")
    WebElement genderradio;
    @FindBy(css="input[type='password']")
    WebElement signUpPass;
    @FindBy(css="input[data-qa='first_name']")
    WebElement firstname;
    @FindBy(css="input[data-qa='last_name']")
    WebElement lastname;
    @FindBy(css="input[data-qa='address']")
    WebElement address;
    @FindBy(css="select[data-qa='country']")
    WebElement selectCountryDrp;
    @FindBy(css="input[data-qa='state']")
    WebElement state;
    @FindBy(css="input[data-qa='city']")
    WebElement city;
    @FindBy(css="input[data-qa='zipcode']")
    WebElement zipcode;
    @FindBy(css="input[data-qa='mobile_number']")
    WebElement mobilenumber;
    @FindBy(css="button[data-qa='create-account']")
    WebElement createAccountButton;
    public void signUpFromAccountDeletePage(String username, String emailid, String password, String firstName, String lastName, String addressInfo,String statename,String cityname,String citycode,String mobileNumber )
    {
        signUpAcountDeletePage.click();
        name.sendKeys(username);
        emailId.sendKeys(emailid);
        signUpButton.click();
       // boolean accountinfomatch=accountInfoText.isDisplayed();
        genderradio.click();
        signUpPass.sendKeys(password);
        firstname.sendKeys(firstName);
        lastname.sendKeys(lastName);
        address.sendKeys(addressInfo);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 500).perform();
        Select sc=new Select(selectCountryDrp);
        sc.selectByValue("Canada");
        state.sendKeys(statename);
        city.sendKeys(cityname);
        zipcode.sendKeys(citycode);
        mobilenumber.sendKeys(mobileNumber);
        createAccountButton.click();
       // return accountinfomatch;
    }

}
