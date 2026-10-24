package Base_Package;

import AbstractComponent.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Field;

public class Listeners extends Base_Test implements ITestListener {

    private final ExtentReports extentReports = ExtentReporterNG.getExtentReport();
    private final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extentReports.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = extentTest.get();
        test.fail(result.getThrowable());

        try {
            WebDriver webDriver = findDriver(result);
            String path = takeScreenshot(result.getMethod().getMethodName(), webDriver);
            test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
        } catch (Exception e) {
            // Don't let a screenshot problem break the listener
            test.warning("Could not attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
        test.skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

    private WebDriver findDriver(ITestResult result) throws Exception {
        Class<?> clazz = result.getTestClass().getRealClass();
        while (clazz != null) {
            try {
                Field f = clazz.getDeclaredField("driver");
                f.setAccessible(true);
                return (WebDriver) f.get(result.getInstance());
            } catch (NoSuchFieldException ignored) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException("No 'driver' field found on " + result.getInstance().getClass());
    }
}