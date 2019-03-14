package com.example.wakeparkby.pchell.maveri.Profile;

import android.app.Activity;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;

public class AdapterProfileFriend extends Activity {

    public AdapterProfileFriend(String userKey) {
        Profile profile = new Profile(userKey);
    }

    protected void startActivityChat() {
        Intent intent_Chat = new Intent(this, ActivityChat.class);
        startActivity(intent_Chat);
    }
}
