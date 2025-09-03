package Tests;

import Configuration.ConfigurationManager;
import Driver.DriverInstance;
import UIPages.DashboardUI;
import UIPages.LoginUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends  TestBase{

    DashboardUI objDashboard;
    LoginUI objLogin;

    @Test
    public void TC01_VerifyInvalidLogin()
    {

        objDashboard = new DashboardUI();
        objDashboard.NavigateToLogin();
        objLogin = new LoginUI();
        objLogin.UserLogin("Rahul@abc.com","123232");
        Assert.assertEquals(DriverInstance.Instance().findElement(By.id("aacb-captcha-header")).getText(),"Solve this puzzle to protect your account");

    }
    @Test
    public void TC02_ValidateEmptyUserName()
    {

        objDashboard = new DashboardUI();
        objDashboard.NavigateToLogin();
        objLogin = new LoginUI();
        objLogin.SetUserName("");
        objLogin.ClickContinue();
        Assert.assertEquals(objLogin.GetValidationError(),"Enter your mobile number or email","Validation for " +
                "Empty username is Passed");

    }

    @Test

    public void TC03_ValidateSearchProductFunctionality()
    {
        objDashboard = new DashboardUI();
        objDashboard.SearchProduct("iphone 16");
        var searchElements =  DriverInstance.Instance().findElements(By.xpath("//*[contains(text(),'iphone 16')]"));
        Assert.assertTrue(searchElements.size() > 0, "No elements found with text 'iphone 16'");
    }

    @Test
    public void TC04_ValidataeSearchProductTitle()
    {
        objDashboard = new DashboardUI();
        objDashboard.SearchProduct("iphone 16");
        var title =  DriverInstance.Instance().getTitle();
        Assert.assertTrue(title.contains("iphone 16"), "Text does not contain expected substring 'iphone 16");
    }

    @Test
    public void TC05_ValidataeInvalidProductTitle()
    {
        objDashboard = new DashboardUI();
        objDashboard.SearchProduct("iphone 16");
        var title =  DriverInstance.Instance().getTitle();
        Assert.assertTrue(title.contains("Suhani"), "Text does not contain expected substring 'iphone 16");
    }
}
