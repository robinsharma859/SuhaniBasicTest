package Driver;


import Configuration.ConfigurationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ChromeBrowser {

    private WebDriver _driver = null;
    private ChromeOptions _options = null;

    public ChromeBrowser()
    {
        super();
        _options = new ChromeOptions();
        SetCapabilities();

    }

    private void SetCapabilities() {
        _options.addArguments("--start-maximized");
        _options.addArguments("--disable-notifications");
    }

    public WebDriver LaunchBrowser() {
        try {
            if(_driver==null) {
                _driver = WebDriverManager.chromedriver().capabilities(_options).create();
                _driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                Integer driverTimeout = Integer.valueOf(ConfigurationManager.Instance().GetValue("GlobalWaitSeconds"));
                _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(driverTimeout));
            }
        }
        catch (Exception ex) {
            System.out.println("Errr occured while lanching browser" + ex.getMessage());
        }
        return _driver;

    }

    public void DisposeDriver()
    {
        if(_driver!=null)
        {
            _driver.close();
            _driver.quit();
        }
    }


}
