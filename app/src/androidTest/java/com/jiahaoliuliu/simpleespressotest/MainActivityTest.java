package com.jiahaoliuliu.simpleespressotest;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

/**
 * Created by jiahao on 09/10/16.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    // Test used to click on all the items in the list
    // Reference: http://stackoverflow.com/questions/28476507/using-espresso-to-click-view-inside-recyclerview-item
    @Test
    public void itemClicksTest() {
        for (int i = 0; i < MainActivity.TestActivity.values().length; i++) {
            onView(withId(R.id.tests_recycler_view))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));

            // Click on the back button on the action bar
            // http://stackoverflow.com/questions/23985181/click-home-icon-with-espresso
            onView(withContentDescription(R.string.abc_action_bar_up_description)).perform(click());

            // It is also possible press back
//            Espresso.pressBack();
        }
    }

    @Test
    public void simpleButtonActivityInvocationTest() {

        // Simple button activity
        onView(withId(R.id.tests_recycler_view))
                .perform(RecyclerViewActions.actionOnItem(hasDescendant(withText(R.string.simple_button_activity)), click()));

        // Check the normal state of the text
        onView(withId(R.id.simple_text_view))
                .check(matches(withText(R.string.simple_text_view)));

        // Click on the button
        onView(withId(R.id.simple_button))
                .perform(click());

        // Check the changes on the text view
        onView(withId(R.id.simple_text_view))
                .check(matches(withText(R.string.simple_text_view_clicked)));

        // Come back to the list
        Espresso.pressBack();
    }
}
