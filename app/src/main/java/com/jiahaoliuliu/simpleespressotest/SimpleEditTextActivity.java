package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.button;

public class SimpleEditTextActivity extends ChildActivity {

    private EditText mSourceEditText;
    private Button mCopyButton;
    private TextView mDestinationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_edit_text);

        // Link the views
        mSourceEditText = (EditText) findViewById(R.id.source_edit_text);
        mCopyButton = (Button) findViewById(R.id.copy_button);
        mDestinationTextView = (TextView) findViewById(R.id.destination_text_view);

        // Set the action
        mCopyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mDestinationTextView.setText(mSourceEditText.getText().toString());
            }
        });
    }
}
