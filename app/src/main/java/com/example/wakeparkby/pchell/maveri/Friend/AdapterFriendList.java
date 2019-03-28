package com.example.wakeparkby.pchell.maveri.Friend;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;

import java.util.ArrayList;

public class AdapterFriendList {
    private ArrayList<ProfileFriend> friends = new ArrayList<>();


    public ArrayList<ProfileFriend> getFriends() {
        return friends;
    }




    public void add(ProfileFriend profileFriend) {
        this.friends.add(profileFriend);
    }

    /*public ProfileFriend getProfileFriend(int id) {
        return this.friends.get(id);
    }*/
}
