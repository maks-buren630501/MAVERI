package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.app.Activity;
import android.content.Intent;

public class AdapterCreateAccount extends Activity {

    protected void startActivityCreateProfile() {
        Intent intent_CreateAccountInfo= new Intent(this, ActivityCreateProfile.class);
        startActivity(intent_CreateAccountInfo);
    }
}
