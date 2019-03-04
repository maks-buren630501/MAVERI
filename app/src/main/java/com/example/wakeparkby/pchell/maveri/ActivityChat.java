package com.example.wakeparkby.pchell.maveri;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChat extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private ImageView sendButton;
    private EditText messageArea;
    private ListView listViewChat;
    private String groupId;
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
                final List<String> chatList = new ArrayList<>();
                for (DataSnapshot battle : chatDS.getChildren())
                    chatList.add((String) battle.getValue());
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
    }
}
