package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;

public class AdapterTimeSelection extends AppCompatActivity {
    protected void startActivityDateSelection() {
        Intent intent_chat = new Intent(this, ActivityChat.class);
        startActivity(intent_chat);
    }
}
