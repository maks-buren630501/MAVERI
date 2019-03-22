package com.example.wakeparkby.pchell.maveri.Profile;


import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;

public class AdapterProfileFriend{
    ProfileFriend profileFriend;

    public AdapterProfileFriend(String userKey) {
        profileFriend = new ProfileFriend(userKey);
    }

    public AdapterProfileFriend(ProfileFriend profileFriend){
        this.profileFriend = profileFriend;
    }

    public AdapterProfileFriend() {

    }

    protected void startActivityChat(Context context) {
        AdapterChat adapterChat = new AdapterChat(this.profileFriend.getUserKey(),Profile.getInstance().getUserKey());

        Intent intent_Chat = new Intent(context, ActivityChat.class);
        context.startActivity(intent_Chat);
    }

    public String getUserFirstName() {
        return this.profileFriend.getFirstName();
    }

    public String getUserLastName() {
        return this.profileFriend.getLastName();
    }

    public String getUserListInterests() {
        return this.profileFriend.getListInterests();
    }
}
