package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriverWait wait;
    public WaitUtils(WebDriver driver){
        long timeoutInSeconds  = Long.parseLong(PropertyReader.getProperty("defaultWait"));
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }
    public WebElement waitForElementVisiblity(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForElementToBeClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitForElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForFrameAndSwitch(By frameLocator) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
    public void waitForUrlToContain(String urlFragment) {
        wait.until(ExpectedConditions.urlContains(urlFragment));
    }
}
