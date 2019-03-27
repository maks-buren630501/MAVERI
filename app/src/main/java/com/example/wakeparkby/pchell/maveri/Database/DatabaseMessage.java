package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.Chat.ListMessage;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;

public class DatabaseMessage extends Observable{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private String groupId;
    private List<String> chatList = new ArrayList<>();
    ObserverMessage observerMessage = new ObserverMessage("DataBaseMessage");
    public DatabaseMessage(){
        observerMessage.setStatus(5);
    }

    public void loadGroupMessage(final String groupId) {
        String str;
        this.groupId = groupId;
        myRefMeessage = database.getReference("Messages" + "/" + groupId + "/Message/");
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                chatList.clear();
                for (DataSnapshot data : chatDS.getChildren())
                    chatList.add(String.valueOf(data.getValue()));
                Profile.getInstance().setAdapterChat(new AdapterChat(groupId, new ListMessage(chatList)));
                observerMessage.notifyAllObservers(1);

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }



    public void sendMessage(String name, String time, String message) {
        myRefMeessage = database.getReference("Messages");
        myRefMeessage.child(Profile.getInstance().getAdapterChat().getGroupId()).child("Message").push().setValue(name + "       " + time + System.lineSeparator() + message);
    }
}
