package PageObjectModels;

import AbstractComponent.Reusable_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_Page extends Reusable_Class
{
    WebDriver driver;
    public Cart_Page(WebDriver driver)
    {
     super(driver);
     this.driver=driver;
     PageFactory.initElements(driver,this);
    }
    @FindBy(css="[href='/view_cart']")
    WebElement cartlink;
    @FindBy(css="li[class='active']")
    WebElement shoppingCartText;
    @FindBy(xpath="//a[text()='Home']")
    WebElement carTtoHome;
    public void cartFunctionalityVerification()
    {
        cartlink.click();
        System.out.println(shoppingCartText.getText());
        carTtoHome.click();;
    }
}
