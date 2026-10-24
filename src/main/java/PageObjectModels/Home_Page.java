package PageObjectModels;

import AbstractComponent.Reusable_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page extends Reusable_Class {
    WebDriver driver;
    public Home_Page(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".fa-home")
    WebElement homePage;
    @FindBy(xpath="//div[@class='productinfo text-center']/h2[text()='Rs. 500']")
    WebElement actionOverProduct;
    public void actionOverProductPage() {
        homePage.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0, 500).perform();
        actions.moveToElement(actionOverProduct).build().perform();

        }
    }




