package PageObjectModels;

import AbstractComponent.Reusable_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Page extends Reusable_Class {
    WebDriver driver;

    public SignIn_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-qa='login-email']")
    WebElement loginEmailId;
    @FindBy(css = "input[data-qa='login-password']")
    WebElement loginPassword;
    @FindBy(css = "button[data-qa='login-button']")
    WebElement loginButton;
    @FindBy(xpath = " //b[text()='Siya']")
    WebElement acountHolderName;
    @FindBy(linkText ="Delete Account")
    WebElement deleteaccount;
    @FindBy(xpath ="//b[text()='Account Deleted!']")
    WebElement msgAfterAccountDeletion;

    public SignUp_Page loginToApplication(String emailId, String password) {
        loginEmailId.sendKeys(emailId);
        loginPassword.sendKeys(password);
        loginButton.click();
        SignUp_Page signUpPage=new SignUp_Page(driver);
        return signUpPage;
    }

    public boolean checkLoggedInPersonNameOnProductPage() {
        boolean nameOnProductPage = acountHolderName.isDisplayed();
        return nameOnProductPage;
    }

    public boolean checkDeleteAccountFromProductPage()
    {
        deleteaccount.click();
        boolean accounDeletedMessage=msgAfterAccountDeletion.isDisplayed();
        return accounDeletedMessage;

    }
}

