package listeners;


import driver.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import utils.FileUtils;
import utils.PropertyReader;
import utils.ScreenshotsManager;
import org.testng.*;
import java.io.File;

public class TestNGListeners implements IExecutionListener,IInvokedMethodListener {
    @Override
    public void onExecutionStart() {
        PropertyReader.loadProperties();
        cleanTestOutputResults();
        createTestOutputDirectories();
    }
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
     if(!method.isTestMethod()) {
         return;
     }
     if(testResult.getInstance() instanceof WebDriverProvider provider) {
         WebDriver driver = provider.getWebDriver();
         if(driver == null) {
            return;
         }
         switch (testResult.getStatus()){

             case ITestResult.SUCCESS -> ScreenshotsManager.takeFullPageScreenshot(driver, "passed-" + testResult.getName());
             case ITestResult.FAILURE -> ScreenshotsManager.takeFullPageScreenshot(driver, "failed-" + testResult.getName());
             case ITestResult.SKIP -> ScreenshotsManager.takeFullPageScreenshot(driver, "skipped-"+ testResult.getName());

         }
     }
    }
    private void cleanTestOutputResults(){
        FileUtils.cleanDirectory(new File(ScreenshotsManager.SCREENSHOT_PATH));
        FileUtils.cleanDirectory(new File(getAllureResultsPath()));
    }
    private void createTestOutputDirectories() {
        FileUtils.createDirectory(ScreenshotsManager.SCREENSHOT_PATH);
    }
    private String getAllureResultsPath() {
        return PropertyReader.getProperty("allure.results.directory") + "/";
    }

}
