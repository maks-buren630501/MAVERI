package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdapterSignIn {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();
    Profile profile;



    public void getUserInfo(String userId) {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        profile = databaseProfile.getProfile(userId);
    }


    public static void startActivityMainMenu(Context context) {
        Intent intent_Main_Menu = new Intent(context, ActivityMainMenu.class);
        context.startActivity(intent_Main_Menu);

    }
}
