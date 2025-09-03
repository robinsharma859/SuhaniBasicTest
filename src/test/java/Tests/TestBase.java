package Tests;
import Configuration.ConfigurationManager;
import Driver.DriverInstance;
import Reporting.ExtentManager;
import UIPages.DashboardUI;
import UIPages.LoginUI;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import  org.testng.util.*;
import  org.testng.Reporter;
import javax.swing.text.Utilities;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestBase {

    protected  WebDriver driver = DriverInstance.Instance();
    protected String ApplicationURL = ConfigurationManager.Instance().GetValue("ApplicationURL");
    private static ExtentReports extent = ExtentManager.getInstance();
//    private  ExtentTest test = ExtentManager.test;
    String testname = "";

    @BeforeMethod
    public void BeforeTest(Method context)
    {
        testname =  context.getName();
        System.out.println("Test Case Name " +  testname);
        ExtentManager.test = extent.createTest(testname);
        driver.navigate().to(ApplicationURL);
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Running once before the test suite.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Running once before the first test method.");
    }

    @AfterMethod
    public void TestCleanUp(ITestResult   result) throws IOException {

        if(ITestResult.FAILURE == result.getStatus())
        {
            String path = TestUtility.TakesScreenshot(result);
            ExtentManager.test.fail(testname + "Falied ");
            ExtentManager.test.addScreenCaptureFromPath(path);
        }
        else if(ITestResult.SKIP == result.getStatus())
        {
            ExtentManager.test.log(Status.SKIP, "Test Skipped");
        }
        else
        {
            ExtentManager.test.log(Status.PASS, "Test Passed");

        }


    }

    @AfterSuite
    public void SuiteCleanUp()
    {
        if(driver!=null)
        {
            driver.close();
            driver.quit();
        }
        extent.flush();
    }

}
