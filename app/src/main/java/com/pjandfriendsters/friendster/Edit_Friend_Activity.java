package com.pjandfriendsters.friendster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_Friend_Activity extends AppCompatActivity {
    private DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbhelper = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__friend_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button editButton = (Button) findViewById(R.id.button);
        final Button deleteButton = (Button) findViewById(R.id.button2);
        final Bundle friendData = getIntent().getExtras();
        if(friendData == null ){
            return;
        }
        String friendMessage = friendData.getString("friendName");
        final EditText editText = (EditText) findViewById(R.id.editTextBox);
        editText.setText(friendMessage);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbhelper.deleteFriend(friendData.getInt("friendId"));
                finish();
                Intent i = new Intent(Edit_Friend_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbhelper.editFriend(friendData.getInt("friendId"), editText.getText().toString());
                finish();
                Intent i = new Intent(Edit_Friend_Activity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }

}
