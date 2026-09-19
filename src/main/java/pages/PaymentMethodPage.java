package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class PaymentMethodPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By paymentMethodTitle = By.xpath("//h3[text()='Choose an electronic payment method']");
    private final By creditCardPaymentOption = By.xpath("//input[@id='credit_card']//following-sibling::span[@class='check-icon']");
    private final By walletPaymentOption = By.xpath("//input[@id='pos']//following-sibling::span[@class='check-icon']");
    private final By agreeTermsCheckbox = By.xpath("//input[@id='terms']//following-sibling::span[@class='check-icon']");
    private final By payNowBtn = By.xpath("//button[text()='Pay and Book Now']");
    private final By date = By.cssSelector(".cart-item.flex-col  .date");
    private static final String EXPECTED_URL_FRAGMENT = "BookingStepTwo";


    public PaymentMethodPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    public String getCurrentUrl() {
        wait.waitForUrlToContain(EXPECTED_URL_FRAGMENT);
        return driver.getCurrentUrl();
    }

    @Step("Choose payment method")
    public String getPaymentMethodTitle() {
        return wait.waitForElementVisiblity(paymentMethodTitle).getText();
    }

    @Step("Choose credit card payment option")
    public CreditCardPaymentPage chooseCreditCardPaymentOption() {
        wait.waitForElementToBeClickable(creditCardPaymentOption).click();
        return new CreditCardPaymentPage(driver);
    }

    @Step("Choose wallet payment option")
    public PaymentMethodPage chooseWalletPaymentOption() {
        wait.waitForElementToBeClickable(walletPaymentOption).click();
        return this;
    }

    @Step("Agree to terms and conditions")
    public PaymentMethodPage agreeToTerms() {
        wait.waitForElementToBeClickable(agreeTermsCheckbox).click();
        return this;
    }

    @Step("Click on Pay Now button")
    public WalletPaymentPage clickPayNowBtn() {
        wait.waitForElementToBeClickable(payNowBtn).click();
        return new WalletPaymentPage(driver);
    }

    public String getTripDateText() {
        return wait.waitForElementVisiblity(date).getText();
    }

}


