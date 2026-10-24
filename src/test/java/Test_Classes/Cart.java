package Test_Classes;
import Base_Package.Base_Test;
import PageObjectModels.Cart_Page;
import org.testng.annotations.Test;
public class Cart extends Base_Test
{
    @Test
    public void cartVerification()
    {
        Cart_Page cart_page=new Cart_Page(driver);
        cart_page.cartFunctionalityVerification();


    }

}
