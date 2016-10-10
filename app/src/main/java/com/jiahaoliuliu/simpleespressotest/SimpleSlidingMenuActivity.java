package com.jiahaoliuliu.simpleespressotest;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SimpleSlidingMenuActivity extends ChildActivity {

    private static final int MENU_ITEM_SLIDING_MENU_ID = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_sliding_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItemSlidingMenu = menu.add(Menu.NONE, MENU_ITEM_SLIDING_MENU_ID, Menu
                .NONE, R.string.action_bar_open_menu)
                .setIcon(R.mipmap.ic_sliding_menu);
        menuItemSlidingMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);

        return super.onCreateOptionsMenu(menu);
    }
}
