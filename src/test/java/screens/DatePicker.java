package screens; /**
 * Date picker popup UI element will be present in this class
 * here we can add more complex method to select date
 */

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DatePicker {

    AndroidDriver driver;
    @FindBy(id = "android:id/button1")
    private WebElement okBtnOnDatePicker;

    public DatePicker(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public TaskCreateScreen clickOnOkBtn() {
        isDisplayed(okBtnOnDatePicker);
        okBtnOnDatePicker.click();
        return new TaskCreateScreen(driver);
    }

    public DatePicker isDisplayed(WebElement element) {
        Assert.assertTrue(BaseTest.waitUntil(element), "element not displayed in 10 seconds");
        return this;
    }

}
