package Tests;
import Configuration.ConfigurationManager;
import Driver.DriverInstance;
import UIPages.DashboardUI;
import UIPages.LoginUI;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import  org.testng.util.*;
import  org.testng.Reporter;
public class TestBase {

    protected  WebDriver driver = DriverInstance.Instance();
    protected String ApplicationURL = ConfigurationManager.Instance().GetValue("ApplicationURL");

    @BeforeTest
    public void BeforeTest()
    {
        driver.navigate().to(ApplicationURL);
    }

    @AfterTest
    public void TestCleanUp()
    {
        if(driver!=null)
        {
            driver.close();
            driver.quit();
        }
    }

}
