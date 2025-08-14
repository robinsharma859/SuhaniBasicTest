package Tests;

import Configuration.ConfigurationManager;
import Driver.DriverInstance;
import UIPages.DashboardUI;
import UIPages.LoginUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
}
