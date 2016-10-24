package com.jiahaoliuliu.simpleespressotest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DialogActivity extends Activity {

    // Views
    private Button mCloseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        // Link the views
        mCloseButton = (Button) findViewById(R.id.close_button);
        mCloseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ((Activity) DialogActivity.this).finish();
            }
        });
    }
}
