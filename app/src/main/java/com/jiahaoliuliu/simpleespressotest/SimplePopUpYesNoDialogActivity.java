package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimplePopUpYesNoDialogActivity extends ChildActivity {

    private AlertDialog mSimpleAlertDialog;
    private Button mDisplayYesNoDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_pop_up_yes_no_dialog);

        // Link the view
        mDisplayYesNoDialogButton = (Button) findViewById(R.id.display_pop_up_button);
        mDisplayYesNoDialogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        // If the alert dialog was not shown, show it
        if (mSimpleAlertDialog != null && !mSimpleAlertDialog.isShowing()) {
            mSimpleAlertDialog.show();
            return;
        }

        // Create a simple alert dialog
        mSimpleAlertDialog = new AlertDialog.Builder(SimplePopUpYesNoDialogActivity.this)
                .setTitle(R.string.alert_dialog_title)
                .setMessage(R.string.alert_dialog_message)
                .setPositiveButton(R.string.alert_dialog_positive_button, null)
                .setNegativeButton(R.string.alert_dialog_negative_button, null)
                .create();

        mSimpleAlertDialog.show();
    }
}
