package com.example.wakeparkby.pchell.maveri.Friend;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;

import java.util.ArrayList;

/**
 * класс для обработки списка друзей
 */
public class AdapterFriendList {
    private ArrayList<ProfileFriend> friends = new ArrayList<>();


    /**
     * метод для получения списка друзей
     * @return список друзей
     */
    public ArrayList<ProfileFriend> getFriends() {
        return friends;
    }


    /**
     * метод для добавления друга в спсок
     * @param profileFriend профиль друга
     */
    public void add(ProfileFriend profileFriend) {
        this.friends.add(profileFriend);
    }

    /*public ProfileFriend getProfileFriend(int id) {
        return this.friends.get(id);
    }*/
}
