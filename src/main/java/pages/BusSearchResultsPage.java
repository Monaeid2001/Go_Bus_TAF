package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class BusSearchResultsPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By chooseTripBtn = By.xpath("(//button[contains(text(),'Choose Trip')])[1]");
    private final By RemoveTripBtn = By.xpath("//button[contains(text(),'Remove Trip')]");
    private final By BookingTripBtn = By.xpath("//button[contains(text(),'Book')]");

    private By travelAndArrivalStations(String station) {

        return By.xpath("//p[contains(text(),'"+station+"')]");
    }
    public BusSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    @Step("Get travel and arrival stations for {station}")
    public String getTravelAndArrivalStations(String station) {
         return wait.waitForElementVisiblity(travelAndArrivalStations(station)).getText();
    }
    @Step("Click on Choose Trip button")
    public BusSearchResultsPage clickChooseTripBtn() {
        wait.waitForElementToBeClickable(chooseTripBtn).click();
        return this;
    }
    @Step("Click on Book Trip button")
    public SeatsSelection clickBookingTripBtn() {
        wait.waitForElementToBeClickable(BookingTripBtn).click();
        return new SeatsSelection(driver);
    }
    @Step("Verify if trip is selected")
    public BusSearchResultsPage isTripSelected() {
        wait.waitForElementVisiblity(RemoveTripBtn).isDisplayed();
        return this;
    }

}
