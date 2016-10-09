package com.jiahaoliuliu.simpleespressotest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jiahaoliuliu.simpleespressotest.MainActivity.TestActivity;

/**
 * Created by jiahao on 09/10/16.
 */

public class TestsListAdapter extends RecyclerView.Adapter<TestsListAdapter.TestViewHolder> {

    private Context mContext;
    private TestActivity[] mTestActivitiesArray;

    public TestsListAdapter(Context context, TestActivity[] testActivitiesArray) {
        this.mContext = context;
        this.mTestActivitiesArray = testActivitiesArray;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.tests_list_item, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        final TestActivity testActivity = mTestActivitiesArray[position];

        holder.mTestTitleTestView.setText(testActivity.getActivityTitleId());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mStartTestActivityIntent = new Intent(mContext, testActivity.getActivityClass());
                mContext.startActivity(mStartTestActivityIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTestActivitiesArray.length;
    }

    public class TestViewHolder extends RecyclerView.ViewHolder {

        TextView mTestTitleTestView;

        public TestViewHolder(View itemView) {
            super(itemView);
            mTestTitleTestView = (TextView) itemView.findViewById(R.id.test_title_text_view);
        }
    }

}
