package com.example.wakeparkby.pchell.maveri.MainMenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.Meeting.ActivityMaps;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.google.firebase.auth.FirebaseAuth;

public class AdapterMainMenu {

    protected static void startActivityFriendList(Context context) {
        Intent intent_friend = new Intent(context, ActivityFriendList.class);
        context.startActivity(intent_friend);

    }

    protected static void startActivityProfile(Context context) {
        Intent intent_profile = new Intent(context, ActivityProfile.class);
        context.startActivity(intent_profile);
    }

    public static void startActivityMaps(Context context) {
        Intent intent_maps = new Intent(context, ActivityMaps.class);
        context.startActivity(intent_maps);
    }
}
