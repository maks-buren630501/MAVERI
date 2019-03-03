package com.example.wakeparkby.pchell.maveri;

import android.support.annotation.NonNull;

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
    private String groupID;
    private String id;
    private String name;
    private String time;
    private String message;
    private HashMap<String,String> listMessages = new HashMap<>();


    public void setId(String groupId) {
        this.groupID = groupId;
        getListMessage();
    }

    public void sendMessage(String id, String name, String time, String message) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.message = message;
        myRefMeessage.push().child(groupID).setValue(name + "    " +time + System.lineSeparator() + message);
    }



    public void getListMessage() {
        myRefMeessage = database.getReference("Messeges"+"/"+groupID);
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                for (DataSnapshot battle : chatDS.getChildren()){
                    listMessages.put(battle.getKey(), String.valueOf(battle.getValue()));

                }
                ListMessage listMessage = new ListMessage();
                listMessage.setListMessage(listMessages);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
