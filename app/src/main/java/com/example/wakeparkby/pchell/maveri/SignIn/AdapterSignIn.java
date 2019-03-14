package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;

public class AdapterSignIn extends AppCompatActivity {

    protected void startActivityMainMenu() {
        Intent intent_Main_Menu = new Intent(this, ActivityMainMenu.class);
        startActivity(intent_Main_Menu);
    }
}
