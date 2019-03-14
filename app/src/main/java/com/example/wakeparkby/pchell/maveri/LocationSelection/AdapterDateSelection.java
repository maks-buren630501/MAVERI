package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class AdapterDateSelection extends Activity {
    protected void startActivityTimeSelection() {
        Intent intent_TimeSelection = new Intent (this,ActivityTimeSelection.class);
        startActivity(intent_TimeSelection);
    }
}
