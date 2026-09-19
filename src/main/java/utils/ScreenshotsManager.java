package utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotsManager {
    public static final String SCREENSHOT_PATH= "test-output/screenshots/";
    public static void takeFullPageScreenshot(WebDriver driver,String screenshotName) {
        try {
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOT_PATH + screenshotName + "-" + System.currentTimeMillis() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);
            AttachToAllure(screenshotName, screenshotFile);
        }catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
    public static void AttachToAllure(String screenshotName, File screenshotFile) {
        try {
           Allure.addAttachment(screenshotName, Files.newInputStream(screenshotFile.toPath()));
        } catch (Exception e) {
            System.out.println("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }
}
