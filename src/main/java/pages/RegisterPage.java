package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class RegisterPage {
    WebDriver driver;
    private final WaitUtils wait;
    private final By fullName = By.xpath("//label[contains(text(),'fullname')]//following-sibling::input");
    private final By phoneNumber = By.xpath("//div[@class='w-full']//input");
    private final By email = By.xpath("//label[contains(text(),'Email')]//following-sibling::input");
    private final By password = By.xpath("//label[contains(text(),'Password')]//following-sibling::input");
    private final By confirmPassword = By.xpath("//label[contains(text(),'Confirm Password')]//following-sibling::input");
    private final By registerSubmitBtn = By.xpath("//button[contains(text(),'Register')]");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtils(driver);
    }
    @Step("Registering with fullName: {fullName}, phoneNumber: {phoneNumber}, email: {email}, password: {password}, confirmPassword: {confirmPassword}")
    public HomePage register(String fullName, String phoneNumber, String email, String password, String confirmPassword) {
        wait.waitForElementVisiblity(this.fullName).sendKeys(fullName);
        wait.waitForElementVisiblity(this.phoneNumber).sendKeys(phoneNumber);
        wait.waitForElementVisiblity(this.email).sendKeys(email);
        wait.waitForElementVisiblity(this.password).sendKeys(password);
        wait.waitForElementVisiblity(this.confirmPassword).sendKeys(confirmPassword);
        wait.waitForElementToBeClickable(registerSubmitBtn).click();
        return new HomePage(driver);
    }
    
}
