package Tests;

import Driver.DriverInstance;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtility
{
    public static String TakesScreenshot(ITestResult result) throws IOException {
       String filePath="";
        try {
            var driver = DriverInstance.Instance();
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File destFile = new File("Screenshots", result.getName() + timestamp + ".png");
            FileUtils.copyFile(screenshot, destFile);
            filePath = destFile.getAbsolutePath();
           return  filePath;
        } catch (RuntimeException e) {
            System.out.println("Error while taking screenshots" + e.getMessage());
        }
        return  filePath;
    }
}
