package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.google.firebase.auth.FirebaseAuth;

public class Profile {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();
    private static String userKey;

    private static String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;

    private static String userFirstName;
    private static String userLastName;
    private static String userAge;
    private static String userSex;
    private static String userListInterests;

    public Profile(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Profile(String id,String firstName,String lastName,String age,String sex,String listInterests) {
        this.userFirstName = firstName;
        this.userLastName = lastName;
        this.userAge = age;
        this.userSex = sex;
        this.userListInterests = listInterests;
        this.userKey = id;
    }

    public void getUserInfo() {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.getUserInfo(userId);
    }

    public Profile(String firstName, String lastName, String age, String sex, String listInterests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;

    }

    public Profile() {
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

    public String getUserId() {
        return userId;
    }

    public String getListInterests() {
        return listInterests;
    }

    public Profile(String userKey) {
        this.userKey = userKey;
    }

    public String getUserKey() {
        return userKey;
    }
    public static String getUserFirstName() {
        return userFirstName;
    }

    public static String getUserLastName() {
        return userLastName;
    }

    public static String getUserAge() {
        return userAge;
    }

    public static String getUserSex() {
        return userSex;
    }

    public static String getUserListInterests() {
        return userListInterests;
    }




}
