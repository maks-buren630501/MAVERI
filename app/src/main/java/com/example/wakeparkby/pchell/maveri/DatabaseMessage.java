package com.example.wakeparkby.pchell.maveri;

import android.support.annotation.NonNull;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseMessage {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private static String groupID;




    public void setId(String groupId) {
        this.groupID = groupId;
    }

    public void sendMessage(String name, String time, String message) {
        myRefMeessage = database.getReference("Messages");
        myRefMeessage.child(groupID).push().setValue(name + "       " +time + System.lineSeparator() + message);
    }
}
