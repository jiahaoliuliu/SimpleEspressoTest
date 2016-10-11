package com.jiahaoliuliu.simpleespressotest;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.close;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.contrib.DrawerMatchers.isOpen;
import static android.support.test.espresso.contrib.NavigationViewActions.navigateTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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
public class SimpleDrawerActivityTest {

    private enum MenuOption {
        CAMERA(R.id.nav_camera, R.string.nav_camera)
        , GALLERY(R.id.nav_gallery, R.string.nav_gallery)
        , SLIDE_SHOW(R.id.nav_slideshow, R.string.nav_slideshow)
        , MANAGE(R.id.nav_manage, R.string.nav_manage)
        , SHARE(R.id.nav_share, R.string.nav_share)
        , SEND(R.id.nav_send, R.string.nav_send)
        ;

        int optionId;
        int optionTextId;

        MenuOption(int optionId, int optionTextId) {
            this.optionId = optionId;
            this.optionTextId = optionTextId;
        }
    }

    @Rule
    public ActivityTestRule<SimpleDrawerActivity> mActivityRule =
                new ActivityTestRule<>(SimpleDrawerActivity.class);

    @Test
    public void testOpenDrawerSliding() throws Exception {
        // Open Drawer and close the drawer
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.END))) // Right Drawer should be closed.
                .perform(open(Gravity.END)) // Open Drawer
                .check(matches(isOpen(Gravity.END)))
                ;
    }

    @Test
    public void testOpenCloseDrawerActionbar() throws Exception {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.END)));

         // Open drawer by clicking on the action bar.
        onView(withId(R.id.action_open_drawer))
                .perform(click());

        onView(withId(R.id.drawer_layout))
                .check(matches(isOpen(Gravity.END)));

        onView(withId(R.id.drawer_layout))
                .perform(close(Gravity.END))
                .check(matches(isClosed(Gravity.END)));
    }

    @Test
    public void testDrawerItemClick() throws Exception {
        // Preconditions
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.END)));
        onView(withId(R.id.content_text_view))
                .check(matches(withText(isEmptyString())));

        // Check each one of the menu options
        for (MenuOption menuOption : MenuOption.values()) {

            // Open drawer by clicking on the action bar.
            onView(withId(R.id.action_open_drawer))
                    .perform(click());

            // Click on the camera option
            onView(withId(R.id.nav_view))
                    .perform(navigateTo(menuOption.optionId));

            // Check the content has changed
            onView(withId(R.id.content_text_view))
                    .check(matches(withText(menuOption.optionTextId)));

            // Close the drawer
            onView(withId(R.id.drawer_layout))
                    .perform(close(Gravity.END));
        }
    }
}
