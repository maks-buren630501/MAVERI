package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

/**
 * класс для работы с профилем друга
 */
public class ProfileFriend {

    private String userKey;
    private static String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;

    /**
     * конструктор с параметрами
     * @param id номер пользователя
     * @param firstName имя
     * @param lastName фамилия
     * @param age возрост
     * @param sex пол
     * @param listInterests ссписок интересов
     */
    public ProfileFriend(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
        this.userKey = id;
    }

    public ProfileFriend() {

    }

    /**
     * метод возрощающий имя
     * @return имя
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * метод возрощающий фамилию
     * @return фамилия
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * метод возрощающий возрост
     * @return возрост
     */
    public String getAge() {
        return age;
    }
    /**
     * метод возрощающий пол
     * @return пол
     */
    public String getSex() {
        return sex;
    }
    /**
     * метод возрощающий список интересов
     * @return список интересов
     */
    public String getListInterests() {
        return listInterests;
    }

    /*public ProfileFriend(String userKey) {
        this.userKey = userKey;
    }*/
    /**
     * метод возрощающий ключ пользователя
     * @return ключ пользователя
     */
    public String getUserKey() {
        return userKey;
    }


}
