package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static WebDriver createDriver(String browser) {
        BrowserDriverFactory factory;
        switch (browser.toLowerCase()) {
            case "chrome":
                factory = new ChromeFactory();
                break;
            case "firefox":
                factory = new FirefoxFactory();
                break;
            case "edge":
                factory = new EdgeFactory();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser +
                        "(Supported Browsers : edge, chrome, firefox)");
        }
        return factory.createDriver();
    }
}
