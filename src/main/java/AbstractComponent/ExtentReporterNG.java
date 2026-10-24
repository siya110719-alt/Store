package AbstractComponent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
    public static ExtentReports getExtentReport()
    {
        String path=System.getProperty("user.dir")+"//Reports//Reports.html";
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Web Automation Result");
        extentSparkReporter.config().setDocumentTitle("Test Results");
        ExtentReports extent= new ExtentReports();
        extent.attachReporter(extentSparkReporter);
        extent.setSystemInfo("Tester","Siya");
        extent.createTest(path);
        return extent;
    }
}
