package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.R;

public class ActivityTimeSelection extends AppCompatActivity implements View.OnClickListener {

    private Button continueButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selection);
        continueButton = findViewById(R.id.buttonSelectTime);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_chat = new Intent(this, ActivityChat.class);
        startActivity(intent_chat);
    }
}
