package screens; /**
 * This class repersents home screen elements
 */

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomeScreen {

    AndroidDriver driver;
    @FindBy(id = "android:id/message")
    private WebElement alertMessage;
    @FindBy(id = "android:id/button1")
    private WebElement okButtonOnAlert;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/next")
    private WebElement nextButton;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/tv_content")
    private WebElement textOnSplashScreen;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomeScreen verifyAlertMessage() {
        isDisplayed(alertMessage);
        Assert.assertEquals(alertMessage.getText(), "This app was built for an older version of Android and may not work properly. Try checking for updates, or contact the developer.");
        return this;
    }


    public HomeScreen isDisplayed(WebElement element) {
        Assert.assertTrue(BaseTest.waitUntil(element), "element not displayed in 10 seconds");
        return this;
    }

    public HomeScreen clickOnOkBtn() {
        okButtonOnAlert.click();
        return this;
    }

    public StartScreen clickOnNextButton() {
        isDisplayed(nextButton);
        nextButton.click();
        return new StartScreen(driver);
    }


}
