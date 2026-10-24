package Test_Classes;

import Base_Package.Base_Test;
import PageObjectModels.SignIn_Page;
import PageObjectModels.SignUp_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Registered_User extends Base_Test {
    SignUp_Page signUpPage;
    @Test
    public void UserSignInAndAccountDeletion() {
        SignIn_Page signInPage = new SignIn_Page(driver);
        signUpPage=signInPage.loginToApplication("Pushkasiya@1107", "Pushpak@1107");
        Assert.assertTrue(signInPage.checkLoggedInPersonNameOnProductPage(), "Logged in as Siya");
        Assert.assertTrue(signInPage.checkDeleteAccountFromProductPage(), "Account Deleted!");
    }
    @Test(dependsOnMethods = "UserSignInAndAccountDeletion")
    public void signUpFromaccountDeletePage()
    {
        signUpPage.signUpFromAccountDeletePage("Siya","Pushkasiya@1107","Pushpak@1107","Siya","abc","abc","abc","abc","12345","123456789");

    }

}
