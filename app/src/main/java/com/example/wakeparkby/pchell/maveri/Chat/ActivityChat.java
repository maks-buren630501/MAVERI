package com.example.wakeparkby.pchell.maveri.Chat;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class ActivityChat extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private ImageView sendButton;
    private EditText messageArea;
    private ListView listViewChat;
    private String groupId;
    private String userKey = "userKey";
    private String a;
    private List<String> chatList = new ArrayList<>();
    AdapterChat adapterChat = new AdapterChat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listViewChat = findViewById(R.id.listViewChat);
        sendButton = findViewById(R.id.sendButton);
        messageArea = findViewById(R.id.messageArea);
        sendButton.setOnClickListener(this);
        adapterChat.getListMessage();
        groupId = adapterChat.getGroupId();
        refreshList();
    }

    private void refreshList() {
        myRefMeessage = database.getReference("Messages" + "/" + groupId + "/");
        myRefMeessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                /// изменить
                final List<String> chatList = new ArrayList<>();
                for(DataSnapshot data: chatDS.getChildren())
                    chatList.add(String.valueOf(data.getValue()));
                ArrayAdapter<String> chatAdapter = new ArrayAdapter<>(ActivityChat.this,
                        android.R.layout.simple_list_item_1,
                        chatList.toArray(new String[chatList.size()]));
                listViewChat.setAdapter(chatAdapter);
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }




    @Override
    public void onClick(View v) {
        String messageText = messageArea.getText().toString();
        adapterChat.sendMessage(messageText);
        messageArea.setText("");
    }
}
