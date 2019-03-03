package com.example.wakeparkby.pchell.maveri;

import java.util.ArrayList;
import java.util.List;

 class Profile {
    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;

    private String userId = "userId";



    public Profile (){}
    public Profile(String id, String firstName, String lastName, String age, String sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
       // ListInterests listInterests = new ListInterests();
      //  final List<String> InterestsList = listInterests.getListInterests();
      //  DatabaseProfile databaseProfile = new DatabaseProfile(InterestsList ,id, firstName, lastName, age, sex);
    }

    public Profile(String userId){
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }


}
