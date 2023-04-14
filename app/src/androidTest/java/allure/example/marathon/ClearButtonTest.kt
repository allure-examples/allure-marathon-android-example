package allure.example.marathon

import android.Manifest
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

internal class ClearButtonTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )
    @Test
    fun shouldGetCorrectValue() = run {
        step("Launch the app") {
            MainScreen {
                incrementButton.isDisplayed()
                clearButton {
                        click()
                }
                valueText.hasText("Count: 0")
            }
        }
    }

}