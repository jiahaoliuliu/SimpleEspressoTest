package com.jiahaoliuliu.simpleespressotest;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.isDialog;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
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
public class ActivityAsDialogActivityTest {

    @Rule
    public ActivityTestRule<ActivityAsDialogActivity>
            mActivityRule = new ActivityTestRule<ActivityAsDialogActivity>(ActivityAsDialogActivity.class);

    @Test
    public void testOnButtonClicked() throws Exception {
        onView(withId(R.id.display_dialog_button))
                // Check the normal state of the button
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.display_dialog)))
                // Click on the button
                .perform(click());

        // TODO: Check the dialog has appeared
        onView(withText(R.string.dialog_activity_message))
                .inRoot(isDialog());

        onView(withId(R.id.close_button))
                .check(matches(isDisplayed()))
                .perform(click());

    }
}
