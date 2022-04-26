package screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ReminderListScreen {

    AndroidDriver driver;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/smallCircle")
    private WebElement addReminderBtn;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/fab")
    private WebElement addReminderBtn22;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/rippleCircle")
    private WebElement addReminderBtn2;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/recycler")
    private WebElement addReminderBtn3;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")
    private WebElement navigationMenuBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"reminder.alarm.clock.todo.task:id/swipeMenu\"]")
    private List<WebElement> itemList;
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"reminder.alarm.clock.todo.task:id/swipeMenu\"]")
    private WebElement reminderItem;
    @FindBy(id = "reminder.alarm.clock.todo.task:id/menuDelete")
    private WebElement deleteIconOnSlide;

    public ReminderListScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public TaskCreateScreen clickOnAddTaskButton() {
        TouchAction action = new TouchAction(driver);
        action.tap(new PointOption().withCoordinates(500, 1100)).waitAction().perform();
        isDisplayed(addReminderBtn22);
        addReminderBtn22.click();
        return new TaskCreateScreen(driver);

    }

    public ReminderListScreen addButtonIsPresent() {
        isDisplayed(addReminderBtn22);
        return this;
    }

    public ReminderListScreen clickAddReminderBtn() {
        isDisplayed(addReminderBtn22);
        addReminderBtn22.click();
        return this;
    }

    public ReminderListScreen verifyIfReminderIsAdded() {
        isDisplayed(reminderItem);
        isDisplayed(itemList.get(0));
        Assert.assertTrue(itemList.size() > 0, "Item not added/created in the list");
        return this;
    }

    public ReminderListScreen slideFirstToLeft() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(482, 395)).moveTo(PointOption.point(0, 395)).release().perform();
        return this;
    }

    public ReminderListScreen deleteItem() {
        isDisplayed(deleteIconOnSlide);
        deleteIconOnSlide.click();
        return this;
    }

    public ReminderListScreen verifyItemisDeleted() {
        isNotDisplayed(reminderItem);
//        Assert.assertFalse(reminderItem.isDisplayed(), "item not deleted");
        return this;
    }

    public ReminderListScreen isDisplayed(WebElement element) {
        Assert.assertTrue(BaseTest.waitUntil(element), "element not displayed in 10 seconds");
        return this;
    }

    public ReminderListScreen isNotDisplayed(WebElement element) {
        Assert.assertFalse(BaseTest.waitUntilDisAppear(element), "element not displayed in 10 seconds");
        return this;
    }
}
