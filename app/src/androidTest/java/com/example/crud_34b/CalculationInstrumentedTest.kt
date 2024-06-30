package com.example.crud_34b

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.crud_34b.ui.activity.CalculationActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(AndroidJUnit4::class)
class CalculationInstrumentedTest {
    @get:Rule
    val testRule = ActivityScenarioRule(CalculationActivity::class.java)
    @Test
    fun checkSum() {
        onView(withId(R.id.number1)).perform(
            typeText("1")
        )

        onView(withId(R.id.number2)).perform(
            typeText("1")
        )

        closeSoftKeyboard()

        Thread.sleep(1500)

        onView(withId(R.id.btnSum)).perform(
            click()
        )

        Thread.sleep(1500)
        onView(withId(R.id.resultText)).check(matches(withText("Login")))
    }

}