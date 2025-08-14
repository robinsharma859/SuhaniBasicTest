package UIPages;

import Driver.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginUI
{
    protected WebDriver _driver= DriverInstance.Instance();
    private WebElement txtemail = this._driver.findElement(By.id("ap_email_login"));
    private WebElement btnContinue = this._driver.findElement(By.xpath("//input[@class='a-button-input']"));

    public LoginUI()
    {

    }

    public void SetUserName(String username)
    {
        txtemail.sendKeys(username);
    }

    public void ClickContinue()
    {
        btnContinue.click();
    }

    public void UserLogin(String userName, String password)
    {
        try {
            if (userName.isEmpty() || password.isEmpty()) {
                System.out.println("User Name and Password is Invalid or empty");
                 throw  new Exception("USer Name and Password is Empty");
            }

            System.out.println("User has navigated to login Screen");
             txtemail.sendKeys(userName);
            System.out.println("User Name is Entered: " + userName);
            Thread.sleep(1000);
             btnContinue.click();
             Thread.sleep(2000);
            WebElement txtPassword = this._driver.findElement(By.id("ap_password"));

            WebElement btnSignIn = this._driver.findElement(By.id("signInSubmit"));
            System.out.println("User has entered the password " + password);
             txtPassword.sendKeys(password);
            btnSignIn.click();
            System.out.println("Sign in button is clicked");
             Thread.sleep(3000);

        }
        catch (Exception ex)
        {
            System.out.println("Error occured while performing login into application" + ex.getMessage());
        }
    }

    public String GetValidationError()
    {
        String message ="";
        try
        {
            WebElement validationMsg = this._driver.findElement(By.xpath("//div[@class='a-alert-content']"));
            var wait  =  new WebDriverWait(_driver, Duration.ofSeconds(20));
            wait.until(x -> validationMsg.isDisplayed());
            message = validationMsg.getText();
        }
        catch (Exception ex)
        {
           System.out.println("Unable to Find Validation for unsucessfull login" + ex.getMessage());
        }
        return message;
    }

//    public String CaptchaWindow()
//    {
//
//    }
}

