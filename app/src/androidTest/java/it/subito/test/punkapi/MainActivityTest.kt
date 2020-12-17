package it.subito.test.punkapi

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun onStartup_button_is_enabled_only_after_text_insert() {
        onView(withId(R.id.brewed_after)).perform(typeText("04-2012"))
        onView(withId(R.id.brewed_before)).perform(typeText("04-2012"))
        onView(withId(R.id.search_button)).check(matches(isEnabled()))
    }
}
