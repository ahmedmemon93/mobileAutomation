package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TaskCreateScreen {
    AndroidDriver driver;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/et_remind_content")
    private WebElement reminderNameTextField;
    @FindBy(xpath = "//android.widget.TextView[@text='Anniversary']")
    private WebElement birthDayIcon;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/alarm_date_picker")
    private WebElement dateField;
    @FindBy(xpath = "//android.widget.TextView [@text='Time']")
    private WebElement timeField;
    @FindBy(xpath = "//android.widget.TextView [@text='Repeat']")
    private WebElement repeatField;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/action_done")
    private WebElement addBtnCheckMark;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/fab")
    private WebElement addReminderBtn22;

    public TaskCreateScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public TaskCreateScreen enterReminderName() {
        isDisplayed(reminderNameTextField);

        return this;
    }

    public TaskCreateScreen selectReminderType(String reminderName) {
        isDisplayed(birthDayIcon);
        birthDayIcon.click();
        try {
            if (addReminderBtn22.isDisplayed()) {
                new ReminderListScreen(driver)
                        .clickOnAddTaskButton()
                        .clickOnDate()
                        .clickOnOkBtn()
                        .selectReminderType("");
            }
        } catch (NoSuchElementException e) {

        }
        return this;
    }

    public DatePicker clickOnDate() {
        isDisplayed(dateField);
        dateField.click();
        return new DatePicker(driver);
    }

    public ReminderListScreen clickOnCreateTaskBtn() {
        isDisplayed(addBtnCheckMark);
        addBtnCheckMark.click();
        return new ReminderListScreen(driver);
    }

    public TaskCreateScreen isDisplayed(WebElement element) {
        Assert.assertTrue(BaseTest.waitUntil(element), "element not displayed in 10 seconds");
        return this;
    }
}
