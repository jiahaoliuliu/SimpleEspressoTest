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
public class SimplePopUpYesNoDialogActivityTest {

    @Rule
    public ActivityTestRule<SimplePopUpYesNoDialogActivity> mActivityRule =
            new ActivityTestRule<>(SimplePopUpYesNoDialogActivity.class);

    @Test
    public void testOnPopUpDialogShown() throws Exception {
        // Click on the button
        onView(withId(R.id.display_pop_up_button))
                .perform(click());

//        int titleId = mActivityRule.getActivity().getResources()
//                .getIdentifier( "title", "id", "" );
//
////         Check if the alert dialog has appeared
//        onView(withId(titleId))
//                .inRoot(isDialog())
//                .check(matches(withText(R.string.alert_dialog_title)))
//                .check(matches(isDisplayed()));

        // The title is a bit tricky
        onView(withText(R.string.alert_dialog_title))
                .inRoot(isDialog())
                .check(matches(isDisplayed()));

        // Message
        onView(withId(android.R.id.message))
                .inRoot(isDialog())
                .check(matches(withText(R.string.alert_dialog_message)))
                .check(matches(isDisplayed()));

        // Positive button
        onView(withId(android.R.id.button1))
                .inRoot(isDialog())
                .check(matches(withText(android.R.string.yes)))
                .check(matches(isDisplayed()));

        // Negative button
        onView(withId(android.R.id.button2))
                .inRoot(isDialog())
                .check(matches(withText(android.R.string.no)))
                .check(matches(isDisplayed()));
    }
}
