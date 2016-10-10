package com.jiahaoliuliu.simpleespressotest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class SimplePopUpListDialogActivity extends ChildActivity {

    private Button mShowPopUpButton;
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_pop_up_list_dialog);

        // Link the views
        mShowPopUpButton = (Button) findViewById(R.id.display_pop_up_button);
        mShowPopUpButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // show pop up dialog
                showPopUpAlertDialog();
            }
        });
    }

    private void showPopUpAlertDialog() {
        // If the popup exists and it is not shown, show it
        if (mAlertDialog != null && !mShowPopUpButton.isShown()) {
            mAlertDialog.show();
            return;
        }

        // Set the list of data
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1);
        arrayAdapter.add(getString(R.string.list_option_1));
        arrayAdapter.add(getString(R.string.list_option_2));
        arrayAdapter.add(getString(R.string.list_option_3));
        arrayAdapter.add(getString(R.string.list_option_4));
        arrayAdapter.add(getString(R.string.list_option_5));

        // Create the dialog
        mAlertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.alert_dialog_language_title)
                .setNegativeButton(android.R.string.no, null)
                .setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mAlertDialog.dismiss();
                    }
                })
                .create();

        // Show the dialog
        mAlertDialog.show();
    }
}
