package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mSimpleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link the views
        mSimpleButton = (Button) findViewById(R.id.simple_button);
        mSimpleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // Change the text on the text view
                mSimpleButton.setText(R.string.simple_button_clicked);
            }
        });
    }
}
