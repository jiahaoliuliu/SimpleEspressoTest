package com.jiahaoliuliu.simpleespressotest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAsDialogActivity extends ChildActivity {

    private Context mContext;
    private Button mDisplayDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_as_dialog);

        // Init the variables
        mContext = this;

        // Link the views
        mDisplayDialogButton = (Button) findViewById(R.id.display_dialog_button);
        mDisplayDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Show extra activity as dialog
                Intent startDialogActivityIntent = new Intent(mContext, DialogActivity.class);
                startActivity(startDialogActivityIntent);
            }
        });
    }
}
