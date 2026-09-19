package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class ChromeFactory implements BrowserDriverFactory {
    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        String executionType = System.getProperty("executionType");
        if(executionType.equalsIgnoreCase("LocalHeadless")) {
            options.addArguments("--headless=new");
        } else if (!executionType.equalsIgnoreCase("Local")) {
            throw new IllegalArgumentException(
                    "Invalid executionType: " + executionType + " (Supported: Local, LocalHeadless)");
        }
        return options;
    }
    @Override
    public WebDriver createDriver() {
        return new ChromeDriver(getOptions());
    }
}
