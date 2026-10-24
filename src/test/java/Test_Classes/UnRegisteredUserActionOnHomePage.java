package Test_Classes;

import Base_Package.Base_Test;
import PageObjectModels.Home_Page;
import org.testng.annotations.Test;
public class UnRegisteredUserActionOnHomePage extends Base_Test
{
 @Test
    public void unRegisteredShoppingToRegisteredUser()
 {
    Home_Page homePage=new Home_Page(driver);
    homePage.actionOverProductPage();
 }
}
