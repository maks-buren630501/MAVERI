package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class AdapterLocationSelection extends AppCompatActivity {
    protected void startActivityDateSelection() {
        Intent intent_DataSelection = new Intent(this, ActivityDateSelection.class);
        startActivity(intent_DataSelection);
    }
}
