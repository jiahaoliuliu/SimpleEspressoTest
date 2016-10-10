package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    enum TestActivity {
        SIMPLE_BUTTON_ACTIVITY(R.string.simple_button_activity, SimpleButtonActivity.class)
        , SIMPLE_CHECK_BOXES_ACTIVITY(R.string.simple_check_boxes_activity, SimpleCheckBoxesActivity.class)
        , SIMPLE_EDIT_TEXT_ACTIVITY(R.string.simple_edit_text_activity, SimpleEditTextActivity.class)
        , SIMPLE_MAP_ACTIVITY(R.string.simple_map_activity, SimpleMapActivity.class)
        , SIMPLE_POP_UP_LIST_DIALOG(R.string.simple_pop_up_list_dialog_activity, SimplePopUpListDialogActivity.class)
        , SIMPLE_POP_UP_YES_NO_DIALOG(R.string.simple_pop_up_yes_no_dialog_activity, SimplePopUpYesNoDialogActivity.class)
        , SIMPLE_RADIO_BUTTONS_ACTIVITY(R.string.simple_radio_buttons_activity, SimpleRadioButtonsActivity.class)
        , SIMPLE_WEB_VIEW_ACTIVITY(R.string.simple_web_view_activity, SimpleWebViewActivity.class)
        ;

        private int mActivityTitleId;
        private Class mActivityClass;

        public int getActivityTitleId() {
            return mActivityTitleId;
        }

        public Class getActivityClass() {
            return mActivityClass;
        }

        TestActivity(int activityTitleId, Class activityClass) {
            this.mActivityTitleId = activityTitleId;
            this.mActivityClass = activityClass;
        }
    }

    private RecyclerView mTestsRecyclerView;
    private RecyclerView.LayoutManager mTestsLayoutManager;
    private TestsListAdapter mTestsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link the views
        mTestsRecyclerView = (RecyclerView) findViewById(R.id.tests_recycler_view);
        mTestsRecyclerView.setHasFixedSize(true);

        // Set the linear manager
        mTestsLayoutManager = new LinearLayoutManager(this);
        mTestsRecyclerView.setLayoutManager(mTestsLayoutManager);

        // Set the adapter
        mTestsListAdapter = new TestsListAdapter(this, TestActivity.values());
        mTestsRecyclerView.setAdapter(mTestsListAdapter);
    }
}