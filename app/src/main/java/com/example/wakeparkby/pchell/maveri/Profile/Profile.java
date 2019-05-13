package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendArray;
import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendList;
import com.example.wakeparkby.pchell.maveri.Friend.FriendListFragment;
import com.example.wakeparkby.pchell.maveri.Friend.ReqestFriend.ListReqestUser;
import com.example.wakeparkby.pchell.maveri.Group.ListGroups;
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
    private AdapterChat adapterChat = new AdapterChat();
    private ListGroups groups = new ListGroups();
    private ListReqestUser reqestUser = new ListReqestUser();


    /**
     * метод возврощающий единственный в системе объект класса пользователь(если объект еще не создан то создается)
     * @return
     */
    public static Profile getInstance() {
        if (instance == null) {        //если объект еще не создан
            instance = new Profile();    //создать новый пустой объект
        }
        return instance;
    }
    /**
     * метод возврощающий единственный в системе объект класса пользователь(если объект еще не создан то создается объект сс параметрами)
     * @return единственный в системе объект класса пользователь
     */
    public static Profile getInstanceWithParam(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        if (instance == null) {        //если объект еще не создан
            instance = new Profile(id, firstName, lastName, age, sex, listInterests);    //создать новый объект
        }
        return instance;
    }

    /**
     * пустой конструктор по умолчанию
     */
    private Profile() {

    }

    /**
     * конструктор с параметрами
     * @param id номер пользователя
     * @param firstName имя
     * @param lastName фамилия
     * @param age возрост
     * @param sex пол
     * @param listInterests список интересов
     */
    public Profile(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        this.userKey = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
    }

    /**
     * метод возврощающий имя
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * метод возврощающий фамилию
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * метод возврощающий возрост
     * @return возрост
     */
    public String getAge() {
        return age;
    }
    /**
     * метод возврощающий пол
     * @return пол
     */
    public String getSex() {
        return sex;
    }
    /**
     * метод возврощающий список интересов
     * @return список интересов
     */
    public String getListInterests() {
        return listInterests;
    }
    /**
     * метод возврощающий ключ пользователя
     * @return ключ пользователя
     */
    public String getUserKey() {
        return userKey;
    }
    /**
     * метод возврощающий список встреч
     * @return список встреч
     */
    public ListMeeting getListMeeting() {
        return this.listMeeting;
    }
    /**
     * метод возврощающий список друзей
     * @return список друзей
     */
    public AdapterFriendList getAdapterFriendList() {
        return adapterFriendList;
    }

    /**
     * метод устанавливающий список друзей
     * @param friends список друзей
     */
    public void setFriendList(AdapterFriendList friends) {
        this.adapterFriendList = friends;
//        FriendListFragment.getArrayAdapter().addAll(friends.getFriends());
    }
    /**
     * метод устанавливающий список сообщений
     * @param chat список сообщений
     */
    public void setAdapterChat(AdapterChat chat) {
        this.adapterChat = chat;
    }

    /**
     * метод возврощающий список сообщений
     * @return список сообщений
     */
    public AdapterChat getAdapterChat() {
        return this.adapterChat;
    }

    public ListGroups getGroups() {
        return groups;
    }

    public void setGroups(ListGroups groups) {
        this.groups = groups;
    }

    public void setReqestFriend(ListReqestUser reqestUser) {
        this.reqestUser = reqestUser;
    }
    public void getReqestFriend(ListReqestUser reqestUser) {
        this.reqestUser = reqestUser;
    }

}
