import org.testng.annotations.Test;
import screens.BaseTest;
import screens.PermissionController;

public class ReminderAppTestScenarios extends BaseTest {
    /**
     * This test make sure app can be launced on a older version of OS with soft Alert message
     * this verify permissions are displayed on first launch
     * Navigate to home screen with add reminder button validation
     */
   // @Test
    public void verifyUserIsAbleToLuanchAppOnOlderVersionWithSoftReminderPopup() {
        PermissionController permissionController = new PermissionController(driver);
        permissionController.verifPhonePermission()
                .verifCallLogPermission()
                .verifContactPermission()
                .clickOnContinue()
                .verifyAlertMessage()
                .clickOnOkBtn()
                .clickOnNextButton()
                .clickStartButton()
                .addButtonIsPresent();
    }

    /**
     * This test will create a new reminder and verify if it is added in list
     * This app has bug and sometimes it crashes the app on adding type field
     */
    //@Test
    public void verifyUserIsAbleAddANewReminderInTheList() {
        PermissionController permissionController = new PermissionController(driver);
        permissionController.verifPhonePermission()
                .verifCallLogPermission()
                .verifContactPermission()
                .clickOnContinue()
                .verifyAlertMessage()
                .clickOnOkBtn()
                .clickOnNextButton()
                .clickStartButton()
                .clickOnAddTaskButton()
                .enterReminderName()
                .clickOnDate()
                .clickOnOkBtn()
                .selectReminderType("")
                .clickOnCreateTaskBtn()
                .verifyIfReminderIsAdded()
                .slideFirstToLeft()
                .deleteItem()
                .verifyItemisDeleted();
    }

    /**
     * This test will try to create a new reminder
     * And later will delete it from list by slide delete button
     */
    @Test
    public  void verifyUserCanDeleteReminderFromList()
    {
        PermissionController permissionController = new PermissionController(driver);
        permissionController.verifPhonePermission()
                .verifCallLogPermission()
                .verifContactPermission()
                .clickOnContinue()
                .verifyAlertMessage()
                .clickOnOkBtn()
                .clickOnNextButton()
                .clickStartButton()
                .clickOnAddTaskButton()
                .enterReminderName()
                .clickOnDate()
                .clickOnOkBtn()
                .selectReminderType("")
                .clickOnCreateTaskBtn()
                .verifyIfReminderIsAdded()
                .slideFirstToLeft()
                .deleteItem()
                .verifyItemisDeleted();
    }
}
