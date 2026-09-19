package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class SeatsSelection {
    WebDriver driver;
    private final WaitUtils wait;
    private final By yourSeat=By.xpath("//h5[contains(text(),'Your Seat')]");
    private final By time = By.xpath("//p[@class='time']");
    private final By date = By.xpath("//p[@class='date']");
    private final By confirmSeatBtn = By.xpath("//div[@class='hide-tablet']//button[contains(text(),'Confirm Seats')]");
    private final String EXPECTED_URL_FRAGMENT = "bookingStepOne";

    public SeatsSelection(WebDriver driver) {
            this.driver = driver;
            wait = new WaitUtils(driver);
    }
    public boolean isYourSeatDisplayed() {
       return wait.waitForElementVisiblity(yourSeat).isDisplayed();
    }
    public String getTime() {
        return wait.waitForElementVisiblity(time).getText();
    }
    @Step("Get the date of the selected seat")
    public String getDate() {
        return wait.waitForElementVisiblity(date).getText();
    }
    public String getCurrentUrl() {
        wait.waitForUrlToContain(EXPECTED_URL_FRAGMENT);
        return driver.getCurrentUrl();
    }
    @Step("Click on the Confirm Seats button")
    public PaymentMethodPage clickConfirmSeatBtn() {
        wait.waitForElementToBeClickable(confirmSeatBtn).click();
        return new PaymentMethodPage(driver);
    }
}
