package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CreditCardPaymentPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By creditCardPaymentHeader = By.xpath("//span[contains(text(),'Credit Cards')]");
    private final By creditCardNumberField= By.cssSelector("iframe.gw-proxy-number");
    private final By nameOnCardField= By.cssSelector("iframe.gw-proxy-nameOnCard");
    private final By expiryMonthField = By.cssSelector("iframe.gw-proxy-expiryMonth");
    private final By expiryYearField = By.cssSelector("iframe.gw-proxy-expiryYear");
    private final By cvvField = By.cssSelector("iframe.gw-proxy-securityCode");
    private final By acceptTermsCheckbox = By.id("ChkAccept");
    private final By inputInsideFrame= By.tagName("input");
    public CreditCardPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
    @Step("Get Credit Card Payment Header")
    public String getCreditCardPaymentHeader() {
        return wait.waitForElementVisiblity(creditCardPaymentHeader).getText();
    }
    @Step("Switch to frame and enter text")
    public void switchToFrameAndEnterText(By frameLocator,String text){
        wait.waitForFrameAndSwitch(frameLocator);
        wait.waitForElementVisiblity(inputInsideFrame).sendKeys(text);
        driver.switchTo().defaultContent();
    }
     @Step("Enter Credit Card Details")
    public CreditCardPaymentPage enterCreditCardDetails(String cardNumber, String nameOnCard, String expiryMonth, String expiryYear, String cvv) {
        switchToFrameAndEnterText(creditCardNumberField, cardNumber);
        switchToFrameAndEnterText(nameOnCardField, nameOnCard);
        switchToFrameAndEnterText(expiryMonthField, expiryMonth);
        switchToFrameAndEnterText(expiryYearField, expiryYear);
        switchToFrameAndEnterText(cvvField, cvv);
        return this;
    }
    @Step("Accept Terms and Conditions")
    public CreditCardPaymentPage acceptTermsAndConditions() {
        wait.waitForElementToBeClickable(acceptTermsCheckbox).click();
        return this;
    }

}
