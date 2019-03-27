package com.example.wakeparkby.pchell.maveri.MainMenu;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;

public class AdapterMainMenu {

    protected static void startActivityFriendList(Context context) {
        Intent intent_friend = new Intent(context, ActivityFriendList.class);
        context.startActivity(intent_friend);

    }

    protected static void startActivityProfile(Context context) {
        Intent intent_profile = new Intent(context, ActivityProfile.class);
        context.startActivity(intent_profile);
    }
}
