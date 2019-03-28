package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;

public class AdapterLocationSelection {
    protected static void startActivityDateSelection(Context context) {
        Intent intent_DataSelection = new Intent(context, ActivityDateSelection.class);
        context.startActivity(intent_DataSelection);
    }
}
