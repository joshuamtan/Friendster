package com.pjandfriendsters.friendster;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_Friend extends AppCompatActivity {
    private DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbhelper = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__friend);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final Button addButton = (Button) findViewById(R.id.addButton);
        final EditText addText = (EditText) findViewById(R.id.editTextBox);

        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dbhelper.insertFriend(addText.getText().toString());
                finish();
                Intent i = new Intent(Add_Friend.this, MainActivity.class);
                startActivity(i);
            }
        });

        setSupportActionBar(toolbar);
    }

}
