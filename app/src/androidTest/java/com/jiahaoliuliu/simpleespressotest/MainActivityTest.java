package com.jiahaoliuliu.simpleespressotest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
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

        onView(withId(R.id.tests_recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

//        for (int i = 0; i < MainActivity.TestActivity.values().length; i++) {
//            onView(withId(R.id.tests_recycler_view))
//                    .perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
//        }
    }
}
