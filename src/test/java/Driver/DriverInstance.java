package Driver;

import Configuration.ConfigurationManager;
import org.openqa.selenium.WebDriver;

public  class DriverInstance {


    private static WebDriver _instance = null;

    public static WebDriver Instance()
    {
        if(_instance==null)
        {
            _instance =  BrowserFactory.InitilizeDriver(ConfigurationManager.Instance().GetValue("BrowserName"));
            System.out.println("Driver Instance launched");
        }
        return _instance;
    }

}
