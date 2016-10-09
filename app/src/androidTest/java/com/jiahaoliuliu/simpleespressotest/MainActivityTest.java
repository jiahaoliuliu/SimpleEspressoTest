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
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by jiahao on 09/10/16.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testOnButtonClicked() throws Exception {
        // Check the normal state of the text
        onView(withId(R.id.simple_text_view))
                .check(matches(withText(R.string.simple_text_view)));

        // Click on the button
        onView(withId(R.id.simple_button))
                .perform(click());

        // Check the changes on the text view
        onView(withId(R.id.simple_text_view))
                .check(matches(withText(R.string.simple_text_view_clicked)));

    }
}
