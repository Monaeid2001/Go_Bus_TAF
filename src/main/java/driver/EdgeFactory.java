package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.PropertyReader;

public class EdgeFactory implements BrowserDriverFactory {
    private EdgeOptions getOptions() {
         EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        String executionType = PropertyReader.getProperty("executionType");
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
        return new EdgeDriver(getOptions());
    }

}
