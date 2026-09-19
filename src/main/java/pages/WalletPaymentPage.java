package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class WalletPaymentPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By bookingCode = By.xpath("//div[contains(text(),'Booking Code')]");
    public WalletPaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    @Step("Get Booking Code")
    public String getBookingCode() {
        return wait.waitForElementVisiblity(bookingCode).getText();
    }
}
