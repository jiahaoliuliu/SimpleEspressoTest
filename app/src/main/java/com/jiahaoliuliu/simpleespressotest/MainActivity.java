package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    enum TestActivity {
        SIMPLE_BUTTON_ACTIVITY(R.string.simple_button_activity, SimpleButtonActivity.class)
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