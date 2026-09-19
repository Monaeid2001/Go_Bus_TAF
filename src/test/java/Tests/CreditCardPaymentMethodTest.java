package Tests;

import driver.DriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterClass;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.JsonReader;
import utils.PropertyReader;

@Epic("Go Bus")
@Feature("Payment Management")
@Story("Pay with Credit Card")
@Severity(SeverityLevel.CRITICAL)
@Owner("Monmon")

public class CreditCardPaymentMethodTest extends BaseTest {
    CreditCardPaymentPage creditCardPaymentPage;
    PaymentMethodPage paymentMethodPage;
    BusSearchResultsPage busSearchResultsPage;
    @Test
    public void loginTest() {
        homePage.chooseEnglish()
                .clickLoginRegisterBtn()
                .login(testData.getJsonData("email"), testData.getJsonData("password"));
        Assert.assertTrue(homePage.isAccountDisplayed(), "User is not logged in.");
    }
    @Test(dependsOnMethods = "loginTest")
    public void searchTripTest(){
        busSearchResultsPage = homePage
                .chooseDepartureCity(testData.getJsonData("busSearch.departureCity"))
                .chooseDepartureStation(testData.getJsonData("busSearch.departureStation"))
                .chooseArrivalCity(testData.getJsonData("busSearch.arrivalCity"))
                .chooseArrivalStation(testData.getJsonData("busSearch.arrivalStation"))
                .chooseTravelDate(testData.getJsonData("busSearch.travelMonthYear"), testData.getJsonData("busSearch.travelDay"))
                .clickSearchBtn();
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Miamy").contains("Miamy"), "Departure station doesn't match expected value");
        Assert.assertTrue(busSearchResultsPage.getTravelAndArrivalStations("Tahrir").contains("Tahrir"), "Arrival station doesn't match expected value");
    }
    @Test(dependsOnMethods = {"loginTest","searchTripTest"})
    public void seatSelectionTest(){
        paymentMethodPage = busSearchResultsPage
                .clickChooseTripBtn()
                .clickBookingTripBtn()
                .clickConfirmSeatBtn();
        Assert.assertEquals(paymentMethodPage.getPaymentMethodTitle(),"Choose an electronic payment method","Payment method title does not match expected value.");
        Assert.assertTrue(paymentMethodPage.getCurrentUrl().contains("BookingStepTwo"));
    }

    @Test(dependsOnMethods = {"loginTest", "seatSelectionTest","searchTripTest"})
    public void creditCardPaymentMethodTest() {
        creditCardPaymentPage=
                paymentMethodPage
                        .chooseCreditCardPaymentOption()
                        .acceptTermsAndConditions()
                        .enterCreditCardDetails(testData.getJsonData("card.number")
                                , testData.getJsonData("card.name")
                                , testData.getJsonData("card.expiryMonth")
                                , testData.getJsonData("card.expiryYear")
                                ,testData.getJsonData("card.cvv"));
        Assert.assertEquals(creditCardPaymentPage.getCreditCardPaymentHeader(), "Credit Cards", "Credit card payment header does not match expected value.");

    }


    @BeforeClass
    public void precondition() {
        testData = new JsonReader("payment-data");
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


