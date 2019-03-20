package com.example.wakeparkby.pchell.maveri.Profile;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
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

    private static String userKey;
    private static String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;
    private ListMeeting listMeeting = new ListMeeting();


    public static Profile getInstance(){
        if(instance == null){		//если объект еще не создан
            instance = new Profile();	//создать новый пустой объект
        }
        return instance;
    }

    public static Profile getInstanceWithParam(String id,String firstName,String lastName,String age,String sex,String listInterests) {
        if(instance == null){		//если объект еще не создан
            instance = new Profile(id,firstName,lastName,age,sex,listInterests);	//создать новый объект
        }
        return instance;
    }



    private Profile(){

    }


   private Profile(String id,String firstName,String lastName,String age,String sex,String listInterests) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.listInterests = listInterests;
        this.userKey = id;
    }

    private Profile(String firstName, String lastName, String age, String sex, String listInterests) {
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

    public ListMeeting getListMeeting(){
        return this.listMeeting;
    }


}
