package com.example.wakeparkby.pchell.maveri.Friend;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;

import java.util.ArrayList;

public class AdapterFriendList  {
    private ArrayList<Profile> friends=new ArrayList<>();


    ArrayList<Profile> getFriends() {
        return friends;
    }
    AdapterFriendList()
    {
        DatabaseProfile databaseProfile = new DatabaseProfile();
      //databaseProfile.getListFriends();
        friends = databaseProfile.getFriends();
    }



}
