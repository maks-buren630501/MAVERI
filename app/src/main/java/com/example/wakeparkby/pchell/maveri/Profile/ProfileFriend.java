package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class ProfileFriend {

    private String userKey;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;


    public ProfileFriend(String id, String firstName, String lastName, String age, String sex, String listInterests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
        this.userKey = id;
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

    /*public ProfileFriend(String userKey) {
        this.userKey = userKey;
    }*/

    public String getUserKey() {
        return userKey;
    }


}
