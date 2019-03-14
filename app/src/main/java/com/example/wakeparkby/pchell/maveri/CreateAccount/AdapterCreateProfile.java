package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

public class AdapterCreateProfile extends Activity {
    protected void startActivitySignIn() {
        Intent intent_signIn = new Intent(this, ActivitySignIn.class);
        startActivity(intent_signIn);
    }
}
