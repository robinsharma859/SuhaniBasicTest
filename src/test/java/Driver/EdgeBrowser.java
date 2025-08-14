package Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class EdgeBrowser {
    private WebDriver _driver = null;
    private EdgeOptions _options = null;

    public EdgeBrowser()
    {
        _options = new EdgeOptions();
        SetCapabilities();

    }

    private void SetCapabilities() {
        _options.addArguments("--start-maximized");
        _options.addArguments("--disable-notifications");
    }

    public WebDriver LaunchBrowser() {
        try {
            if(_driver==null) {
                _driver = WebDriverManager.edgedriver().capabilities(_options).create();
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
