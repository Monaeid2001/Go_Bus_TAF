# Go Bus Automation Framework

## Description

**Go Bus Automation Framework** is a web test automation project using Selenium WebDriver, Java, and TestNG for testing the Go Bus booking website.

The project is designed to be modular and maintainable using the Page Object Model (POM) design pattern. It includes features such as cross-browser testing, data-driven testing using JSON files, custom waits, screenshots, TestNG listeners, Allure reporting, and CI/CD integration using GitHub Actions.

## Repository Information

* **Owner:** [Monaeid2001]
* **Repository URL:** [Go-Bus Automation](YOUR_REPOSITORY_URL)
* **Primary Language:** Java

## 🚀 Features

* **Web Application Testing:** Utilize Selenium WebDriver for browser automation.
* **Page Object Model (POM):** Separate page locators and actions from test logic for better maintainability.
* **Cross-Browser Testing:** Support for Chrome, Firefox, and Microsoft Edge.
* **Driver Factory:** Manage browser initialization using separate browser factory classes.
* **Data-Driven Testing:** Support test data using JSON files.
* **Screenshot Capture:** Capture screenshots to help with test failure investigation and debugging.
* **Custom Waits:** Implement reusable wait methods for better synchronization.
* **Custom Listeners:** Use TestNG listeners to manage test execution events.
* **Configuration Management:** Manage framework settings through property files.
* **Allure Reports:** Generate detailed test execution reports.
* **CI/CD Integration:** GitHub Actions integration for automated test execution.
* **Reusable Utilities:** Utility classes for common framework operations.

## 🛠️ Tools & Technologies

* **Java:** Programming language.
* **Selenium WebDriver:** Browser automation.
* **TestNG:** Test case structuring, execution, and assertions.
* **Maven:** Dependency management and build automation.
* **JSON:** Test data management.
* **Allure Reports:** Test execution reporting.
* **GitHub Actions:** CI/CD integration.
* **Page Object Model:** Framework design pattern.

### Prerequisites

* Java Development Kit (JDK) installed
* Maven installed
* IDE such as IntelliJ IDEA or Eclipse
* Google Chrome, Firefox, or Microsoft Edge
* Allure CLI installed for viewing reports

### Installation

1. Clone the repository:

```sh
git clone YOUR_REPOSITORY_URL
```

2. Navigate to the project directory:

```sh
cd Go-Bus
```

3. Install Maven dependencies:

```bash
mvn clean install -DskipTests
```

### Run the Tests

**Execute all tests:**

```bash
mvn clean test
```

**Run a specific test class:**

```bash
mvn -Dtest=TestClassName test
```

Example:

```bash
mvn -Dtest=LoginTest test
```

**Run a specific test method:**

```bash
mvn -Dtest=TestClassName#testMethodName test
```

### Allure Report

After running the tests:

```bash
allure serve test-output/allure-results
```

To generate a permanent report:

```bash
allure generate test-output/allure-results --clean -o allure-report
```

Then open it using:

```bash
allure open allure-report
```

## 📄 Project Structure

```text
Go-Bus/
├── .github/
│   └── workflows/
│       └── E2E Regression Pipline.yml
│
├── pom.xml
│
└── src/
    ├── main/
    │   ├── java/
    │   │   ├── driver/
    │   │   │   ├── BrowserDriverFactory.java
    │   │   │   ├── ChromeFactory.java
    │   │   │   ├── DriverManager.java
    │   │   │   ├── EdgeFactory.java
    │   │   │   ├── FirefoxFactory.java
    │   │   │   └── WebDriverProvider.java
    │   │   │
    │   │   ├── listeners/
    │   │   │   └── TestNGListeners.java
    │   │   │
    │   │   ├── pages/
    │   │   │   ├── HomePage.java
    │   │   │   ├── LoginPage.java
    │   │   │   ├── RegisterPage.java
    │   │   │   ├── BusSearchResultsPage.java
    │   │   │   ├── SeatsSelection.java
    │   │   │   ├── PaymentMethodPage.java
    │   │   │   ├── CreditCardPaymentPage.java
    │   │   │   └── WalletPaymentPage.java
    │   │   │
    │   │   └── utils/
    │   │       ├── FileUtils.java
    │   │       ├── JsonReader.java
    │   │       ├── PropertyReader.java
    │   │       ├── ScreenshotsManager.java
    │   │       └── WaitUtils.java
    │   │
    │   └── resources/
    │       ├── META-INF/
    │       │   └── services/
    │       │       └── org.testng.ITestNGListener
    │       ├── allure.properties
    │       ├── config.properties
    │       └── wait.properties
    │
    └── test/
        ├── java/
        │   └── Tests/
        │       ├── BaseTest.java
        │       ├── RegisterTest.java
        │       ├── LoginTest.java
        │       ├── BusSearchResultsTest.java
        │       ├── SeatSelectionTest.java
        │       ├── CreditCardPaymentMethodTest.java
        │       └── WalletPaymentMethodTest.java
        │
        └── resources/
            └── test-data/
                ├── booking-data.json
                ├── login-data.json
                ├── payment-data.json
                └── register-data.json
```

## Contributing

Contributions are welcome. Please fork the repository and create a pull request.

## License

This project is intended for educational and test automation practice purposes.

## Contact

For questions or support, feel free to reach out:


* **Email:** [mona.eid.yiehia@gmail.com]
* **GitHub:** https://github.com/Monaeid2001
