package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FireFoxBrowser {

    private WebDriver _driver = null;
    private FirefoxOptions _options = null;

    public FireFoxBrowser()
    {
        _options = new FirefoxOptions();
        SetCapabilities();

    }

    private void SetCapabilities() {
        _options.addArguments("--start-maximized");
        _options.addArguments("--disable-notifications");
    }

    public WebDriver LaunchBrowser() {
        try {
            if(_driver==null) {
                _driver = WebDriverManager.firefoxdriver().capabilities(_options).create();
                _driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
                _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            }
        }
        catch (Exception ex) {
            System.out.println("Errr occured while launching  Edge browser" + ex.getMessage());
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
