package screens;/*
This class is base test to initialize/install apk
This will handle before and after test and method runs
 */
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    public static AndroidDriver driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public BaseTest() {
    }

    public static boolean waitUntil(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean waitUntilDisAppear(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.invisibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void test33() {

    }

    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("avd", "Pixel3A");
        capabilities.setCapability("platformVersion", "5.6");
        capabilities.setCapability("deviceName", "Pixel3A");
        capabilities.setCapability("platformName", "Android");//msTodo.apk //reminder.alarm.clock.todo.task-1.0.2.ap
        //  capabilities.setCapability("app", System.getProperty("user.dir") +"/src/test/resources/msTodo.apk");
        //capabilities.setCapability("app", System.getProperty("user.dir") +"/src/test/resources/reminder.alarm.clock.todo.task-1.0.2.apk");

        capabilities.setCapability("autoGrantPermissions", "true");
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("fullReset", false);
//        capabilities.setCapability("appPackage", "com.microsoft.todos");
//        capabilities.setCapability("appActivity","com.microsoft.todos.onboarding.StartActivity");
        capabilities.setCapability("appPackage", "reminder.alarm.clock.todo.task");
        capabilities.setCapability("appActivity", "meevii.daily.beatles.reminder.activity.SplashActivity");

    }

    @BeforeMethod
    public void beforeMethod() {
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @AfterTest
    public void aftertest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
