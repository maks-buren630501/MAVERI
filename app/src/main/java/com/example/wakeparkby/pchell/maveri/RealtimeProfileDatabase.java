package com.example.wakeparkby.pchell.maveri;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RealtimeProfileDatabase {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefProfile = database.getReference("Profile");
    private String userName;
    private String userLastName;
    private String userAge;
    private String userSex;
    private String userID;
    private String profileUserName;
    private String profileUserLastName;
    private String profileUserAge;
    private String profileUserSex;



    public RealtimeProfileDatabase(String userName, String userLastName, String userAge, String userSex, String userID) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userSex = userSex;
        this.userID = userID;
        SetProfileDatabase();
    }

    private void SetProfileDatabase() {
        myRefProfile = database.getReference("/" + userID);
        myRefProfile.child("First name: ").setValue(userName);
        myRefProfile.child("Last name: ").setValue(userLastName);
        myRefProfile.child("Age: ").setValue(userAge);
        myRefProfile.child("Sex ").setValue(userSex);
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
}
