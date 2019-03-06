package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


// String userKey = mAuth.getCurrentUser().getUid();  получение userkey
public class Profile {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();


    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private List<String> listInterests = new ArrayList<String>();

    public void getUserInfo() {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.getUserInfo(userId);
    }

    public Profile(String firstName, String lastName, String age, String sex, List<String> listInterests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
        // ListInterests listInterests = new ListInterests();
        //  final List<String> InterestsList = listInterests.getListInterests();
        //  DatabaseProfile databaseProfile = new DatabaseProfile(InterestsList ,id, firstName, lastName, age, sex);
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

    public List<String> getListInterests() {
        return listInterests;
    }


    public Profile(String userId) {
        this.userId = userId;
    }




}
