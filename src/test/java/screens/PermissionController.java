package screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PermissionController {

    AndroidDriver driver;
    @FindBy(id = "com.android.permissioncontroller:id/continue_button")
    private WebElement continueButtonOnPermission;
    @FindBy(xpath = "//android.widget.TextView [@text='Contacts']")
    private WebElement contactsPermission;
    @FindBy(xpath = "//android.widget.TextView [@text='Phone']")
    private WebElement phonePermission;
    @FindBy(xpath = "//android.widget.TextView [@text='Call logs']")
    private WebElement callLogsPermission;
    @FindBy(xpath = "//android.widget.TextView [@text='Storage']")
    private WebElement storagePermission;

    public PermissionController(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public HomeScreen clickOnContinue() {
        continueButtonOnPermission.click();
        return new HomeScreen(driver);
    }

    public PermissionController verifPhonePermission() {
        Assert.assertTrue(phonePermission.isDisplayed(), "Phone permission not found");
        return this;
    }

    public PermissionController verifCallLogPermission() {
        Assert.assertTrue(callLogsPermission.isDisplayed(), "call log permission not found");
        return this;
    }

    public PermissionController verifContactPermission() {
        Assert.assertTrue(phonePermission.isDisplayed(), "Contact permission not found");
        return this;
    }

    public PermissionController storagePermission() {
        Assert.assertTrue(phonePermission.isDisplayed(), "storage permission not found");
        return this;
    }
}
