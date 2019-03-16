package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;

public class AdapterSignIn {

    protected static void startActivityMainMenu(Context context) {
        Intent intent_Main_Menu = new Intent(context, ActivityMainMenu.class);
        context.startActivity(intent_Main_Menu);

    }
}
