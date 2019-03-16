package com.example.wakeparkby.pchell.maveri.Profile;


import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;

public class AdapterProfileFriend{

    public AdapterProfileFriend(String userKey) {
        Profile profile = new Profile(userKey);
    }

    protected static void startActivityChat(Context context) {
        Intent intent_Chat = new Intent(context, ActivityChat.class);
        context.startActivity(intent_Chat);
    }

}
