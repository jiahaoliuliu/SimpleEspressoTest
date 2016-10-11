package com.jiahaoliuliu.simpleespressotest;

import android.support.test.espresso.Espresso;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;

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
public class SimpleEditTextActivityTest {

    private String textToCheck = "SimpleText";

    @Rule
    public ActivityTestRule<SimpleEditTextActivity> mActivityRule = new ActivityTestRule<>(SimpleEditTextActivity.class);

    @Test
    public void testCopyTexts() throws Exception {

        // Check for empty text
        onView(withId(R.id.source_edit_text))
                .check(matches(withText(isEmptyString())));
        onView(withId(R.id.destination_text_view))
                .check(matches(withText(isEmptyString())));

        // Set some text
        onView(withId(R.id.source_edit_text))
                .perform(typeText(textToCheck), closeSoftKeyboard());

        // Click on the button
        onView(withId(R.id.copy_button))
                .perform(click());

        // Check the result has been copied
        onView(withId(R.id.destination_text_view))
                .check(matches(withText(textToCheck)));
    }
}
