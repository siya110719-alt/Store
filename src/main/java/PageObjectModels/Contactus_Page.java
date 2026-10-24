package PageObjectModels;

import AbstractComponent.Reusable_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactus_Page extends Reusable_Class
{
    WebDriver driver;
    public Contactus_Page(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "a[href='/contact_us']")
    WebElement contactuslink;
    @FindBy(css="input[data-qa='name']")
    WebElement name;
    @FindBy(css="input[data-qa='email']")
    WebElement email;
    @FindBy(css="input[data-qa='subject']")
    WebElement subject;
    @FindBy(css="textarea[data-qa='message']")
    WebElement textArea;
    @FindBy(xpath="//input[@type='file']")
    WebElement file;
    @FindBy(css="input[data-qa='submit-button']")
    WebElement submitbutton;

    //WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));

    //uploadFile.sendKeys("C:\Users\Siya\Downloads\Manual testing Part 1.pdf");
    public void verificationOfContactUsPage(String Name,String Email,String Subject,String TextingArea)
    {
        waitForElementToBeVisible(By.cssSelector("a[href='/contact_us']"));
        contactuslink.click();
        name.sendKeys(Name);
        email.sendKeys(Email);
        subject.sendKeys(Subject);
        textArea.sendKeys(TextingArea);
        WebElement uploadFile=file;
        uploadFile.sendKeys("C:\\Users\\Siya\\Downloads\\Manual testing Part 1.pdf");
        submitbutton.click();
        driver.switchTo().alert().accept();
    }

}
