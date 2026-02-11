package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String scenarioName){

        try{

            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            String path = "screenshots/"
                    + scenarioName.replaceAll(" ", "_")
                    + "_" + timestamp + ".png";

            FileUtils.copyFile(source, new File(path));

            System.out.println("Screenshot saved: " + path);

        }catch(IOException e){

            e.printStackTrace();
        }
    }
}
