package com.example.wakeparkby.pchell.maveri;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RealtimeMessageDatabase {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage = database.getReference("Messeges");
    private String autor;
    private String message;
    private String time;


    public RealtimeMessageDatabase(String autor, String message, String time) {
        this.autor = autor;
        this.message = message;
        this.time = time;
        SetMessagesDatabase();
    }

    private void SetMessagesDatabase() {
        myRefMeessage.push().setValue(autor + "    " +time + System.lineSeparator() + message);
    }



    public void GetMessagesDatabase() {
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                final List<String> chatList = new ArrayList<String>();
                for (DataSnapshot battle : chatDS.getChildren())
                    chatList.add((String) battle.getValue());
        //        ActivityChat activityChat = new ActivityChat();
        //        activityChat.setChatList(chatList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
