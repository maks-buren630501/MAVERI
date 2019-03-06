package com.example.wakeparkby.pchell.maveri.Database;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseProfile {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefProfile;
    private String id;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private List<String> listInterests = new ArrayList<String>();
    private String profileUserName;
    private String profileUserLastName;
    private String profileUserAge;
    private String profileUserSex;



    public DatabaseProfile(List<String> listInterests , String id, String firstName, String lastName, String age, String sex) {
        this.listInterests = listInterests;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        SetProfileDatabase();
    }
    public DatabaseProfile(){}

    private void SetProfileDatabase() {
        myRefProfile = database.getReference("/" + id);
        myRefProfile.child("First name:").setValue(firstName);
        myRefProfile.child("Last name:").setValue(lastName);
        myRefProfile.child("Age:").setValue(age);
        myRefProfile.child("Sex:").setValue(sex);
        myRefProfile.child("Interests:").setValue(listInterests);

    }

    private void GetProfileDatabase() {
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot userTasksDS) {
                final List<String> userTaskList = new ArrayList<String>();
                for (DataSnapshot battle : userTasksDS.getChildren()){
                    if (battle.getKey().equals("First name: ")){
                        profileUserName = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Last name: ")){
                        profileUserLastName = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Age: ")){
                        profileUserAge = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Sex: ")){
                        profileUserSex = String.valueOf(battle.getValue());
                    }
                }
                //ActivityProfile activityProfile = new ActivityProfile(profileUserName,profileUserLastName,profileUserAge,profileUserSex);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void getUserInfo(String userId) {
        myRefProfile = database.getReference("Users"+"/" + userId );
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot giveSeasonTicketDS) {
                firstName = String.valueOf(giveSeasonTicketDS.child("FirstName").getValue());
                lastName = String.valueOf(giveSeasonTicketDS.child("LastName").getValue());
                age = String.valueOf(giveSeasonTicketDS.child("Age").getValue());
                age = String.valueOf(giveSeasonTicketDS.child("Sex").getValue());
                listInterests = (List<String>) giveSeasonTicketDS.child("Interests").getValue();
                Profile profile = new Profile(firstName, lastName, age, sex,listInterests);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}