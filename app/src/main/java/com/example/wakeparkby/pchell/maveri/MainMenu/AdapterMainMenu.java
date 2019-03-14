package com.example.wakeparkby.pchell.maveri.MainMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.google.firebase.auth.FirebaseAuth;

public class AdapterMainMenu extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();
    public void getUserInfo() {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.getUserInfo(userId);
    }

    protected void startActivityFriendList() {
        Intent intent_friend = new Intent(this, ActivityFriendList.class);
        startActivity(intent_friend);
    }
}
