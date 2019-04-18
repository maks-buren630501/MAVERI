package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;

import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseGroup {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefGroup;


    public void addNewGroup(String status, String date, String time, String name, String description, String coordinates, String password) {
        myRefGroup = database.getReference("Group/").push();
        myRefGroup.child("Status").setValue(status);
        myRefGroup.child("Description").setValue(description);
        myRefGroup.child("Date").setValue(date);
        myRefGroup.child("Time").setValue(time);
        myRefGroup.child("Name").setValue(name);
        myRefGroup.child("Сoordinates").setValue(coordinates);
        myRefGroup.child("Administrator").setValue(Profile.getInstance().getUserKey());
        if (status.equals("1")) {
            myRefGroup.child("Password").setValue(password);
        }
    }

    public void loadAllGroup() {
        myRefGroup = database.getReference("Group/");
        myRefGroup.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot groupDS) {
                //chatList.clear();
                for (DataSnapshot allGroup : groupDS.getChildren()) {
                    String groupKey = String.valueOf(allGroup.getValue());
                    String name = String.valueOf(groupDS.child(groupKey).child("Name"));
                    String date = String.valueOf(groupDS.child(groupKey).child("Date"));
                    String description = String.valueOf(groupDS.child(groupKey).child("Description"));
                    String coordinates = String.valueOf(groupDS.child(groupKey).child("LatLng"));
                    String time = String.valueOf(groupDS.child(groupKey).child("Time"));
                    String status = String.valueOf(groupDS.child(groupKey).child("Status"));
                    if (status.equals("1")) {
                        String password = String.valueOf(groupDS.child(groupKey).child("Password"));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void loadUserGroup() {
        myRefGroup = database.getReference("Users/" + Profile.getInstance().getUserKey() + "/Group/");
        myRefGroup.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot groupDS) {
                //chatList.clear();
                for (DataSnapshot allGroup : groupDS.getChildren()) {
                    String groupKey = String.valueOf(allGroup.getValue());
                    String name = String.valueOf(groupDS.child(groupKey).child("Name"));
                    String date = String.valueOf(groupDS.child(groupKey).child("Date"));
                    String description = String.valueOf(groupDS.child(groupKey).child("Description"));
                    String coordinates = String.valueOf(groupDS.child(groupKey).child("LatLng"));
                    String time = String.valueOf(groupDS.child(groupKey).child("Time"));
                    String status = String.valueOf(groupDS.child(groupKey).child("Status"));
                    if (status.equals("1")) {
                        String password = String.valueOf(groupDS.child(groupKey).child("Password"));
                    }
                    String administrator = String.valueOf(groupDS.child(groupKey).child("Administrator"));
                    if (administrator.equals(Profile.getInstance().getUserKey())) {
                        administrator = "1";
                    } else {
                        administrator = "0";
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void addUserGroup(){
        myRefGroup = database.getReference("Users/" + Profile.getInstance().getUserKey() + "/Group/").push();


    }

}
