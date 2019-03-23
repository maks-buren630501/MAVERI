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

    public void loadGroupMessage(final String groupId) {
        String str;
        this.groupId = groupId;
        myRefMeessage = database.getReference("Messages" + "/" + groupId + "/");
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                for (DataSnapshot data : chatDS.getChildren())
                    chatList.add(String.valueOf(data.getValue()));
                Profile.getInstance().setAdapterChat(new AdapterChat(groupId, new ListMessage(chatList)));
                notifyObservers();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void sendMessage(String name, String time, String message) {
        myRefMeessage = database.getReference("Messages");
        myRefMeessage.child(groupId).push().setValue(name + "       " + time + System.lineSeparator() + message);
    }
}
