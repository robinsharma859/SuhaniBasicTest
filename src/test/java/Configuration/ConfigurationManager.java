package Configuration;

public class ConfigurationManager {

    private  static ConfigurationReader _configReader = null;
    private  ConfigurationManager()
    {

    }

    public static ConfigurationReader Instance()
    {
        if(_configReader==null)
        {
            _configReader = new ConfigurationReader();
        }
        return _configReader;
    }

}
