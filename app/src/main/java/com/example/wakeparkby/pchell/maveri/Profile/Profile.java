package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendArray;
import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendList;
import com.example.wakeparkby.pchell.maveri.Friend.FriendListFragment;
import com.example.wakeparkby.pchell.maveri.Meeting.ListMeeting;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


/**
 * this class for encapsulate info about profile
 */
public class Profile {
    /*
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();
    */
    private static Profile instance;

    private String userKey;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;
    private ListMeeting listMeeting = new ListMeeting();
    private AdapterFriendList adapterFriendList = new AdapterFriendList();
    AdapterChat adapterChat = new AdapterChat();


    public static Profile getInstance() {
        if (instance == null) {        //если объект еще не создан
            instance = new Profile();    //создать новый пустой объект
        }
        return instance;
    }

    public static Profile getInstanceWithParam(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        if (instance == null) {        //если объект еще не создан
            instance = new Profile(id, firstName, lastName, age, sex, listInterests);    //создать новый объект
        }
        return instance;
    }


    private Profile() {

    }


    public Profile(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        this.userKey = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getListInterests() {
        return listInterests;
    }

    public String getUserKey() {
        return userKey;
    }

    public ListMeeting getListMeeting() {
        return this.listMeeting;
    }

    public AdapterFriendList getAdapterFriendList() {
        return adapterFriendList;
    }

    public void setFriendList(AdapterFriendList friends) {
        this.adapterFriendList = friends;
//        FriendListFragment.getArrayAdapter().addAll(friends.getFriends());
    }

    public void setAdapterChat(AdapterChat chat) {
        this.adapterChat = chat;
    }

    public AdapterChat getAdapterChat() {
        return this.adapterChat;
    }
}
