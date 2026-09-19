package Tests;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;
import utils.PropertyReader;

@Epic("Go Bus")
@Feature("Login")
@Story("Login with valid and invalid credentials")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @Test
    public void validLoginTest() {
        homePage =
             homePage.chooseEnglish()
                     .clickLoginRegisterBtn()
                     .login(testData.getJsonData("email"), testData.getJsonData("password"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not logged in.");

    }
    @Test
    public void inValidLoginTest(){
        loginPage =
                homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .loginWithInvalidCredentials(testData.getJsonData("email"), testData.getJsonData("invalidPassword"));
        Assert.assertEquals(loginPage.getLoginErrorMessage(),testData.getJsonData("messages.error"),"Error message is not displayed as expected");
    }



@BeforeClass
    public void precondition() {
        testData = new JsonReader("login-data");
    }
    @BeforeMethod
        public void setUp() {
        driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
        driver.navigate().to(PropertyReader.getProperty("baseUrl"));
        driver.manage().window().setSize(new Dimension(1024, 768));
       homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
