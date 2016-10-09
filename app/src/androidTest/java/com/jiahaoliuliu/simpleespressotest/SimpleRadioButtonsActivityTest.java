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
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

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
public class SimpleRadioButtonsActivityTest {

    private int[] radioButtonsId = {R.id.radio_button_1, R.id.radio_button_2, R.id.radio_button_3, R.id.radio_button_4,
        R.id.radio_button_5, R.id.radio_button_6, R.id.radio_button_7};

    @Rule
    public ActivityTestRule<SimpleRadioButtonsActivity> mActivityRule = new ActivityTestRule<>(SimpleRadioButtonsActivity.class);

    @Test
    public void testCheckRadioButtons() throws Exception {

        // Check the initial state
        checkAllRadioButtonsUnchecked();

        for (int radioButtonId : radioButtonsId) {
            checkRadioButton(radioButtonId);
        }
    }

    private void checkAllRadioButtonsUnchecked() {
        for (int radioButtonId : radioButtonsId) {
            onView(withId(radioButtonId))
                    .check(matches(isNotChecked()));
        }
    }

    private void checkRadioButton(int radioButtonId) {
        // Check it was unchecked
        onView(withId(radioButtonId))
                .check(matches(isNotChecked()));

        // Click on the radio button
        onView(withId(radioButtonId))
                .perform(click());

        // Check it is checked
        onView(withId(radioButtonId))
                .check(matches(isChecked()));

        // Check all the rest of the radio buttons are unchecked
        for (int otherRadioButtonId : radioButtonsId) {
            // If it is the current radio button id, skip
            if (otherRadioButtonId == radioButtonId) {
                continue;
            }

            onView(withId(otherRadioButtonId))
                    .check(matches(isNotChecked()));
        }
    }
}
