package com.example.wakeparkby.pchell.maveri.Profile;


import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;

import java.util.Observable;
import java.util.Observer;

public class AdapterProfileFriend  {
    ProfileFriend profileFriend;

    /*public AdapterProfileFriend(String userKey) {
        profileFriend = new ProfileFriend(userKey);
    }*/

    public AdapterProfileFriend(ProfileFriend profileFriend) {
        this.profileFriend = profileFriend;
    }

    public AdapterProfileFriend(String userId, String userFirstName, String userLastName, String userAge, String userSex, String userListInterests) {
       profileFriend = new ProfileFriend(userId, userFirstName, userLastName, userAge, userSex, userListInterests);
    }

    protected void startActivityChat(Context context) {

        AdapterChat adapterChat = new AdapterChat(this.profileFriend.getUserKey(), Profile.getInstance().getUserKey());
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

    public String getUserId() {
        return this.profileFriend.getUserKey();
    }

    public String getUserSex() {
        return this.profileFriend.getSex();
    }

    public String getUserAge() {
        return this.profileFriend.getAge();
    }


}
