package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;

public class AdapterTimeSelection {
    protected static void startActivityMainMenu(Context context) {
        Intent intent_MainMenu = new Intent(context, ActivityMainMenu.class);
        context.startActivity(intent_MainMenu);
    }
}
