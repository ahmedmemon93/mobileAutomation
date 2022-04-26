package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class StartScreen {

    AndroidDriver driver;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/start")
    private WebElement startButton;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/tv_content1")
    private WebElement textOnStartScreen;

    public StartScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public StartScreen addButtonIsPresent() {

        return this;
    }

    public ReminderListScreen clickStartButton() {
        isDisplayed(startButton);
        startButton.click();
        return new ReminderListScreen(driver);
    }

    public StartScreen isDisplayed(WebElement element) {
        Assert.assertTrue(BaseTest.waitUntil(element), "element not displayed in 10 seconds");
        return this;
    }

}
