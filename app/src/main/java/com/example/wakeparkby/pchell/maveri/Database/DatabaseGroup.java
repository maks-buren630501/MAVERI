package com.example.wakeparkby.pchell.maveri.Database;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        myRefGroup.child("LatLng").setValue(coordinates);
        if (status.equals("1")){
            myRefGroup.child("Password").setValue(password);
        }
    }
}
