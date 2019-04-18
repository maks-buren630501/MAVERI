package com.example.wakeparkby.pchell.maveri.Profile;


import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;

import java.util.Observable;
import java.util.Observer;

/**
 * класс для связи объекта интерфейса профиля друга с логикой
 */
public class AdapterProfileFriend  {
    ProfileFriend profileFriend;

    /*public AdapterProfileFriend(String userKey) {
        profileFriend = new ProfileFriend(userKey);
    }*/

    /**
     * конструктор с 1 параметром
     * @param profileFriend профлиль друга
     */
    public AdapterProfileFriend(ProfileFriend profileFriend) {
        this.profileFriend = profileFriend;
    }

    /**
     * конструктор с параметрами
     * @param userId номер полззователя
     * @param userFirstName Имя
     * @param userLastName Фамилия
     * @param userAge возрост
     * @param userSex пол
     * @param userListInterests список интересов
     */
    public AdapterProfileFriend(String userId, String userFirstName, String userLastName, String userAge, String userSex, String userListInterests) {
       profileFriend = new ProfileFriend(userId, userFirstName, userLastName, userAge, userSex, userListInterests);
    }

    /**
     * метод создания объекта интерфейса чата
     * @param context стандартнйы параметр
     */
    protected void startActivityChat(Context context) {

        AdapterChat adapterChat = new AdapterChat(this.profileFriend.getUserKey(), Profile.getInstance().getUserKey());
            Intent intent_Chat = new Intent(context, ActivityChat.class);
            context.startActivity(intent_Chat);

    }


    /**
     * метод возврощающий имя
     * @return имя
     */
    public String getUserFirstName() {
        return this.profileFriend.getFirstName();
    }
    /**
     * метод возврощающий фамилию
     * @return фамилия
     */
    public String getUserLastName() {
        return this.profileFriend.getLastName();
    }
    /**
     * метод возврощающий список интересов
     * @return список интересов
     */
    public String getUserListInterests() {
        return this.profileFriend.getListInterests();
    }
    /**
     * метод возврощающий номер
     * @return номер
     */
    public String getUserId() {
        return this.profileFriend.getUserKey();
    }
    /**
     * метод возврощающий пол
     * @return пол
     */
    public String getUserSex() {
        return this.profileFriend.getSex();
    }
    /**
     * метод возврощающий возрост
     * @return возрост
     */
    public String getUserAge() {
        return this.profileFriend.getAge();
    }


}
