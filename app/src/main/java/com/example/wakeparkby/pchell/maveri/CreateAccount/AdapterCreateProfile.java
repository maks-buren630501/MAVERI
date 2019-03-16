package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

public class AdapterCreateProfile {
    protected static void startActivitySignIn(Context context) {
        Intent intent_signIn = new Intent(context, ActivitySignIn.class);
        context.startActivity(intent_signIn);
    }
}
