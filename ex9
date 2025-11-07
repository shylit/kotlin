package com.example.module2_file2_ex8


import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private fun setScreen() {
        composeTestRule.setContent {
            MaterialTheme {
                WaterTracker()
            }
        }
    }


     // 1) Кнопка добавления жидкости существует и увеличивает счётчик на +250 мл.

    @Test
    fun addButton_incrementsBy250() {
        setScreen()

        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        composeTestRule.onNodeWithTag("addButton").performClick()

        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()
    }

    //2) Кнопка "Завершить день": при достижении >=1500 мл увеличивает счётчик дней и обнуляет воду.

    @Test
    fun finishDay_reachesThreshold_incrementsStreakAndResetsWater() {
        setScreen()

        repeat(6) { composeTestRule.onNodeWithTag("addButton").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()

        composeTestRule.onNodeWithTag("finishDayButton").performClick()

        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("Серия дней ≥ 1500 мл: 1").assertIsDisplayed()
    }

// 3) Текст о серии дней отображается. Если день завершён с количеством <1500, серия сбрасывается в 0.
    @Test
    fun streakText_exists_andResetsIfBelowThreshold() {
        setScreen()

        composeTestRule.onNodeWithTag("streakText")
            .assertIsDisplayed()
        composeTestRule.onNodeWithText("Серия дней ≥ 1500 мл: 0")
            .assertIsDisplayed()

        repeat(5) { composeTestRule.onNodeWithTag("addButton").performClick() }
        composeTestRule.onNodeWithText("1250 мл").assertIsDisplayed()

        composeTestRule.onNodeWithTag("finishDayButton").performClick()

        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Серия дней ≥ 1500 мл: 0").assertIsDisplayed()
    }
//4) 2 дня подряд
    @Test
    fun streakText_increasesTo2AfterTwoSuccessfulDays() {
        setScreen()

        repeat(6) { composeTestRule.onNodeWithTag("addButton").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeTestRule.onNodeWithTag("finishDayButton").performClick()
        composeTestRule.onNodeWithText("Серия дней ≥ 1500 мл: 1").assertIsDisplayed()

        repeat(6) { composeTestRule.onNodeWithTag("addButton").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeTestRule.onNodeWithTag("finishDayButton").performClick()
        composeTestRule.onNodeWithText("Серия дней ≥ 1500 мл: 2").assertIsDisplayed()
    }
}
