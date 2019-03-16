package com.example.wakeparkby.pchell.maveri.Friend;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;

import java.util.ArrayList;

public class AdapterFriendList  {
    private ArrayList<ProfileFriend> friends=new ArrayList<>();


    ArrayList<ProfileFriend> getFriends() {
        return friends;
    }
    AdapterFriendList()
    {
        DatabaseProfile databaseProfile = new DatabaseProfile();
      //databaseProfile.getListFriends();
        friends = databaseProfile.getFriends();
    }



}
