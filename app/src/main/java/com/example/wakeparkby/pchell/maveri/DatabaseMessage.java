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
    private String id;
    private String name;
    private String time;
    private String message;



    public void setId(String groupId) {
        this.groupID = groupId;
    }

    public void sendMessage(String id, String name, String time, String message) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.message = message;
        myRefMeessage = database.getReference("Messages");
        myRefMeessage.child(groupID).push().setValue("ilya" + "    " +time + System.lineSeparator() + message);
    }
}
