package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.ListMessage;
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
    private String groupId;
    private List<String> chatList = new ArrayList<>();

    public void loadGroupMessage(String groupId) {
        String str;
        this.groupId = groupId;
        myRefMeessage = database.getReference("Messages" + "/" + groupId + "/");
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                for (DataSnapshot data : chatDS.getChildren())
                    chatList.add(String.valueOf(data.getValue()));
                /*ArrayAdapter<String> chatAdapter = new ArrayAdapter<>(ActivityChat.this,
                        android.R.layout.simple_list_item_1,
                        chatList.toArray(new String[chatList.size()]));*/
                //listViewChat.setAdapter(chatAdapter);
                ListMessage listMessage = new ListMessage();
                listMessage.setChatList(chatList);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void sendMessage(String name, String time, String message) {
        myRefMeessage = database.getReference("Messages");
        myRefMeessage.child(groupId).push().setValue(name + "       " +time + System.lineSeparator() + message);
    }
}
