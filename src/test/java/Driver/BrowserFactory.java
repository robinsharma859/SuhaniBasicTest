package Driver;

import org.openqa.selenium.WebDriver;

public  class BrowserFactory {

    private  static  ChromeBrowser _chromeBrowser = null;
    private  static EdgeBrowser _edgeBrowser = null;
    private static FireFoxBrowser _fireFoxDriver = null;


    private  BrowserFactory()
    {}

    public static  WebDriver InitilizeDriver(String browserName)
    {
        WebDriver _driver = null;
        try {

            switch (browserName.toUpperCase())
            {
                case "CHROME":
                    _chromeBrowser = new ChromeBrowser();
                    _driver= _chromeBrowser.LaunchBrowser();
                    break;
                case "FIREFOX":
                    _fireFoxDriver = new FireFoxBrowser();
                    _driver= _fireFoxDriver.LaunchBrowser();
                    break;
                case "EDGE":
                    _edgeBrowser = new EdgeBrowser();
                    _driver= _edgeBrowser.LaunchBrowser();
                    break;
                default:
                    _chromeBrowser = new ChromeBrowser();
                    _driver= _chromeBrowser.LaunchBrowser();
            }

        }
        catch (Exception ex)
        {
          System.out.println("Error Occured While Initizing Driver in Factory " + ex.getMessage());
        }
        return _driver;
    }
}
