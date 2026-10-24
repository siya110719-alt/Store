package Base_Package;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_Test
{
    public WebDriver driver;
    @BeforeMethod
    public void initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "//src//test//Properties_File//Global.properties");
        prop.load(fis);
        String browsername=System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
        // String browsername=prop.getProperty("browser");
        if(browsername.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();


        } else if (browsername.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();

        }
        else if(browsername.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");

    }
    public String takeScreenshot(String testCaseName,WebDriver driver) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"//reports"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+"//reports"+testCaseName+".png";
    }

}
