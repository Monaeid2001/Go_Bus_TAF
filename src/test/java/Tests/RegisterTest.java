package Tests;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.JsonReader;
import utils.PropertyReader;

@Epic("Go Bus")
@Feature("Registration")
@Story("Register a new user")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")

public class RegisterTest extends BaseTest {


    @Test
    public void registerTest(){
        homePage=
                       homePage.chooseEnglish()
                        .clickLoginRegisterBtn()
                        .clickRegisterBtn()
                        .register(testData.getJsonData("name")
                                , testData.getJsonData("phone")
                                , testData.getJsonData("email")+System.currentTimeMillis()+"@gmail.com"
                                , testData.getJsonData("password")
                                , testData.getJsonData("confirmPassword"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not registered.");

    }
    @BeforeClass
    public void precondition() {
        testData = new JsonReader("register-data");
        driver = DriverManager.createDriver(PropertyReader.getProperty("browser"));
        driver.navigate().to(PropertyReader.getProperty("baseUrl"));
        driver.manage().window().setSize(new Dimension(1024, 768));
        homePage = new HomePage(driver);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
