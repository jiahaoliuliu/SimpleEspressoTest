package com.jiahaoliuliu.simpleespressotest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SimpleDrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "SimpleDrawerActivity";

    private static final int MENU_ITEM_SLIDING_MENU_ID = 1000;

    // Views
    private DrawerLayout mDrawer;
    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Link the views
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mContentTextView = (TextView) findViewById(R.id.content_text_view);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItemSlidingMenu = menu.add(Menu.NONE, MENU_ITEM_SLIDING_MENU_ID, Menu
                .NONE, R.string.action_bar_open_menu)
                .setIcon(R.mipmap.ic_sliding_menu);
        menuItemSlidingMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case MENU_ITEM_SLIDING_MENU_ID:
                openDrawer();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch(item.getItemId()) {
            case R.id.nav_camera:
                mContentTextView.setText(R.string.nav_camera);
                break;
            case R.id.nav_gallery:
                mContentTextView.setText(R.string.nav_gallery);
                break;
            case R.id.nav_slideshow:
                mContentTextView.setText(R.string.nav_slideshow);
                break;
            case R.id.nav_manage:
                mContentTextView.setText(R.string.nav_manage);
                break;
            case R.id.nav_share:
                mContentTextView.setText(R.string.nav_share);
                break;
            case R.id.nav_send:
                mContentTextView.setText(R.string.nav_send);
                break;
        }

        closeDrawer();
        return true;
    }

    private void openDrawer() {
        if (mDrawer == null) {
            Log.w(TAG, "Trying to close the drawer but it s null");
            return;
        }

        mDrawer.openDrawer(GravityCompat.END);
    }

    private void closeDrawer() {
        if (mDrawer == null) {
            Log.w(TAG, "Trying to close the drawer but it s null");
            return;
        }

        mDrawer.closeDrawer(GravityCompat.END);
    }
}
