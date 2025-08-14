package UIPages;

import Driver.DriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardUI {

    private WebDriver _driver = DriverInstance.Instance();

    public DashboardUI()
    {
    }
    private  WebElement loginLink = _driver.findElement(By.id("nav-link-accountList"));
    private WebElement btnAddToCart =  _driver.findElement(By.id("nav-cart-count"));
    private WebElement labelAccountLogin =  _driver.findElement(By.id("nav-link-accountList-nav-line-1"));
    private WebElement txtSearch =  _driver.findElement(By.id("twotabsearchtextbox"));
    private WebElement btnSearch =  _driver.findElement(By.id("nav-search-submit-button"));

    public void SearchProduct(String productName)
    {
        try
        {
            System.out.println("User has initiated Product Search");
            txtSearch.sendKeys(productName);
            System.out.println("Product Name: " + productName + "is entered in Search test box");
            Thread.sleep(500);
            btnSearch.click();
            System.out.println("Search Button is clicked");
            Thread.sleep(3000);
        }
        catch (Exception ex)
        {
            System.out.println("Error while Searching Product" + ex.getMessage());
        }
    }

    public  void NavigateToLogin()
    {
        try
        {
            loginLink.click();
            Thread.sleep(2000);
        }
        catch (Exception ex)
        {
            System.out.println("Error occured " + ex.getMessage());
        }
    }

}
