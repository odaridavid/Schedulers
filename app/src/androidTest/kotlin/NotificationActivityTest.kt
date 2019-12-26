import android.content.Intent
import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until
import com.dari.schedulers.R
import com.dari.schedulers.notifications.NotificationActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotificationActivityTest {

    private val activityTestRule =
        ActivityTestRule<NotificationActivity>(NotificationActivity::class.java, false, false)

    @Test
    fun shouldDisplayNotificationOnClicked() {
        val intent = Intent()
        activityTestRule.launchActivity(intent)
        SystemClock.sleep(1000)
        onView(withId(R.id.send_notification_button)).perform(click())
        val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        uiDevice.openNotification()
        uiDevice.wait(Until.hasObject(By.textStartsWith("Schedulers")), 2000)
    }
}