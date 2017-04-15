package com.pjandfriendsters.friendster;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Edit_Friend_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__friend_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle friendData = getIntent().getExtras();
        if(friendData == null ){
            return;
        }
        String friendMessage = friendData.getString("friendName");
        final EditText editText = (EditText) findViewById(R.id.editTextBox);
        editText.setText(friendMessage);
    }

}
