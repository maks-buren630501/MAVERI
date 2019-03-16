package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

public class AdapterCreateAccount {
    protected static void startActivityCreateProfile(Context context) {
        Intent intent_CreateAccountInfo = new Intent(context, ActivityCreateProfile.class);
        context.startActivity(intent_CreateAccountInfo);
    }
}
