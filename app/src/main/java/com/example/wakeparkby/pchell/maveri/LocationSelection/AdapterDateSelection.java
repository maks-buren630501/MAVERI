package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;

public class AdapterDateSelection {
    protected static void startActivityTimeSelection(Context context) {
        Intent intent_TimeSelection = new Intent(context, ActivityTimeSelection.class);
        context.startActivity(intent_TimeSelection);
    }
}
