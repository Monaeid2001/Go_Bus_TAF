package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class HomePage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By loginRegisterBtn = By.xpath("//div[@class='login-button']/a");
    private final By EnglishBtn = By.xpath("//button[text()='English']");
    private final By departureCity = By.xpath("//label[text()='Travel from City']/following-sibling::div");
    private final By departureStation = By.xpath("//label[text()='Travel from Station']/following-sibling::div");
    private final By inputField = By.xpath("//input[@class='search-inputs']");
    private final By arrivalCity = By.xpath("//label[text()='Travel to City']/following-sibling::div");
    private final By arrivalStation = By.xpath("//label[text()='Travel to Station']/following-sibling::div");
    private final By travelDate= By.xpath("//label[text()='Travel Date']/following-sibling::div");
    private final By submitTravelBtn = By.xpath("//button[contains(text(),'Show Go Bus Trips')]");
    private final By chooseDate= By.cssSelector("input[placeholder='Choose Date']");
    private final By calenderHeader = By.className("react-datepicker__current-month");
    private final By nextMonthBtn = By.cssSelector("button[aria-label='Next Month']");
    private final By myAccountBtn = By.xpath("//div[text()='My Account']");

    private By getOptionLocator(String value) {
        return By.xpath("//li[contains(text(),'"+value+"')]");
    }
    private By selectDay(String day) {
        return By.xpath("//div[@aria-disabled='false' and text()='"+day+"']");
    }

    public HomePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    @Step("Clicking on Login/Register button")
    public LoginPage clickLoginRegisterBtn(){
        int attempts = 0;
        while (attempts < 3) {
            try {
                wait.waitForElementToBeClickable(loginRegisterBtn).click();
                return new LoginPage(driver);
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to click element after retries: " + loginRegisterBtn);
    }
  @Step("Choosing English language")
    public HomePage chooseEnglish(){
        wait.waitForElementToBeClickable(EnglishBtn).click();
        return this;
    }
    @Step("Choosing Departure City: {city}")
    public HomePage chooseDepartureCity(String city) {
        wait.waitForElementToBeClickable(departureCity).click();
        wait.waitForElementVisiblity(inputField).sendKeys(city);
        wait.waitForElementToBeClickable(getOptionLocator(city)).click();
        return this;
    }
    @Step("Choosing Departure Station: {station}")
    public HomePage chooseDepartureStation(String station) {
        wait.waitForElementToBeClickable(departureStation).click();
        wait.waitForElementVisiblity(inputField).sendKeys(station);
        wait.waitForElementToBeClickable(getOptionLocator(station)).click();
        return this;
    }
    @Step("Choosing Arrival City: {city}")
    public HomePage chooseArrivalCity(String city) {
        wait.waitForElementToBeClickable(arrivalCity).click();
        wait.waitForElementVisiblity(inputField).sendKeys(city);
        wait.waitForElementToBeClickable(getOptionLocator(city)).click();
        return this;
    }
    @Step("Choosing Arrival Station: {station}")
    public HomePage chooseArrivalStation(String station) {
        wait.waitForElementToBeClickable(arrivalStation).click();
        wait.waitForElementVisiblity(inputField).sendKeys(station);
        wait.waitForElementToBeClickable(getOptionLocator(station)).click();
        return this;
    }
    @Step("Choosing Travel Date: {monthYear} {day}")
    public HomePage chooseTravelDate(String monthYear, String day){
       wait.waitForElementToBeClickable(chooseDate).click();
        while (!wait.waitForElementVisiblity(calenderHeader).getText().contains(monthYear)){
            wait.waitForElementToBeClickable(nextMonthBtn).click();
        }
        wait.waitForElementToBeClickable(selectDay(day)).click();
        return this;
    }
    @Step("Clicking on Search button")
    public BusSearchResultsPage clickSearchBtn(){
        wait.waitForElementToBeClickable(submitTravelBtn).click();
        return new BusSearchResultsPage(driver);
    }
    @Step("Checking if My Account button is displayed")
    public boolean isAccountDisplayed(){
      return  wait.waitForElementVisiblity(myAccountBtn).isDisplayed();
    }



}
