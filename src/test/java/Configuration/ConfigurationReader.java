package Configuration;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader
{
    private Properties _properties = null;
    FileInputStream _stream = null;
    public ConfigurationReader()
    {
        _properties = new Properties();
        LoadFile();
    }

    private void  LoadFile()
    {
       try {

           _stream =  new FileInputStream("src/test/java/Configuration/GlobalParam.properties");
           _properties.load(_stream);
       }
       catch (Exception ex)
       {
           System.out.println("Error Occured while Reading Properties File" + ex.getMessage());
       }
    }

    public String GetValue(String propertyKey)
    {
        String propertyValue = "";
         if(propertyKey==null || propertyKey.isEmpty())
         {
             return  "Invalid key";
         }
        propertyValue =  _properties.getProperty(propertyKey);
        System.out.println("Property name : " +  propertyKey + " value is  "+   propertyValue);
         return propertyValue;
    }


}
