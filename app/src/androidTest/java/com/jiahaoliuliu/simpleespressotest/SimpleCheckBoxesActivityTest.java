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
public class SimpleCheckBoxesActivityTest {

    @Rule
    public ActivityTestRule<SimpleCheckBoxesActivity> mActivityRule = new ActivityTestRule<>(SimpleCheckBoxesActivity.class);

    @Test
    public void testCheckUncheckCheckBoxes() throws Exception {

        // Check each one of the check boxes
        checkCheckBox(R.id.check_box_1);
        checkCheckBox(R.id.check_box_2);
        checkCheckBox(R.id.check_box_3);
        checkCheckBox(R.id.check_box_4);
        checkCheckBox(R.id.check_box_5);
        checkCheckBox(R.id.check_box_6);
        checkCheckBox(R.id.check_box_7);

        // Uncheck the check boxes
        uncheckCheckBox(R.id.check_box_7);
        uncheckCheckBox(R.id.check_box_6);
        uncheckCheckBox(R.id.check_box_5);
        uncheckCheckBox(R.id.check_box_4);
        uncheckCheckBox(R.id.check_box_3);
        uncheckCheckBox(R.id.check_box_2);
        uncheckCheckBox(R.id.check_box_1);
    }

    private void checkCheckBox(int checkBoxId) {
        onView(withId(checkBoxId))
                .check(matches(isNotChecked()));

        onView(withId(checkBoxId))
                .perform(click());

        onView(withId(checkBoxId))
                .check(matches(isChecked()));
    }

    private void uncheckCheckBox(int checkBoxId) {
        onView(withId(checkBoxId))
                .check(matches(isChecked()));

        onView(withId(checkBoxId))
                .perform(click());

        onView(withId(checkBoxId))
                .check(matches(isNotChecked()));
    }

}
