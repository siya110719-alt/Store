package AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Reusable_Class
{
    WebDriver driver;

    public Reusable_Class(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
        public void waitForElementToBeVisible(By findBy) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
        }
    public void waitForElementToBeClickable(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    // wait for a LIST of WebElements to all be visible
    public void waitForAllElementsToBeVisible(List<WebElement> elementList) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
    }
    }

