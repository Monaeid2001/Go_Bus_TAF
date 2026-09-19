package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By emailOrPhoneInput = By.xpath("//label[contains(text(),'Email or Phone Number')]/following-sibling::input");
    private final By passwordInput = By.xpath("//label[contains(text(),'Password')]/following-sibling::input");
    private final By loginSubmitBtn = By.xpath("//button[contains(text(),'Login')]");
    private final By registerBtn = By.xpath("//a[text()='Register']");
    private final By loginErrorMessage = By.xpath("//div[contains(text(),'Not Found')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    @Step("Log in with email or phone: {emailOrPhone}")
    public HomePage login(String emailOrPhone, String password) {
        wait.waitForElementVisiblity(emailOrPhoneInput).sendKeys(emailOrPhone);
        wait.waitForElementVisiblity(passwordInput).sendKeys(password);
        wait.waitForElementToBeClickable(loginSubmitBtn).click();
        return new HomePage(driver);
    }
    @Step("Log in with invalid credentials: {emailOrPhone}")
    public LoginPage loginWithInvalidCredentials(String emailOrPhone, String password) {
        wait.waitForElementVisiblity(emailOrPhoneInput).sendKeys(emailOrPhone);
        wait.waitForElementVisiblity(passwordInput).sendKeys(password);
        wait.waitForElementToBeClickable(loginSubmitBtn).click();
        return this;
    }
    @Step("Click Register Button")
    public RegisterPage clickRegisterBtn() {
        wait.waitForElementToBeClickable(registerBtn).click();
        return new RegisterPage(driver);
    }
    @Step("getting Login error message")
    public String getLoginErrorMessage() {
        return wait.waitForElementVisiblity(loginErrorMessage).getText();
    }
}
