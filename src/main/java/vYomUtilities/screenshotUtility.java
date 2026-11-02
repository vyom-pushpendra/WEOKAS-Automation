package vYomUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtility {

    public static String captureScreenshot(WebDriver driver,
                                           String testName,
                                           String status) {

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        // Create Pass/Fail folder
        String folderPath = "Screenshots" + File.separator + status;

        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String screenshotPath = folderPath + File.separator
                + testName + "_" + timeStamp + ".png";

        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        File destFile = new File(screenshotPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}