package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxFactory implements BrowserDriverFactory {
    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        // Disable notifications
        options.addPreference("dom.webnotifications.enabled", false);
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        String executionType = System.getProperty("executionType");
        if (executionType.equalsIgnoreCase("LocalHeadless")) {
            options.addArguments("--headless=new");
        } else if (!executionType.equalsIgnoreCase("Local")) {
            throw new IllegalArgumentException(
                    "Invalid executionType: " + executionType + " (Supported: Local, LocalHeadless)");
        }
        return options;
    }
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver(getOptions());
    }
}
