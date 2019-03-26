package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityLocationSelection;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ActivityChat extends AppCompatActivity implements View.OnClickListener{
    AdapterChat adapterChat = Profile.getInstance().getAdapterChat();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private ImageView sendButton;
    private ImageView selectPlaceButton;
    private EditText messageArea;
    private ListView listViewChat;
    private String groupId;
    private String userKey = "userKey";
    private String a;
    private List<String> chatList = adapterChat.getListMessage().getMessages();
    //AdapterChat adapterChat = new AdapterChat();


    ObserverMessage observer = new ObserverMessage("Chat") {

        /**

         * override method of Observer class with new reaction for notify observers

         */

        @Override
        public void update() {

            if (observer.getStatus() == 10) {

                if (observer.getId() == 1) {
                    refreshList();
                    observer.setId(0);
                }
                else {

                }
            }
        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listViewChat = findViewById(R.id.listViewChat);
        sendButton = findViewById(R.id.sendButton);
        messageArea = findViewById(R.id.messageArea);
        sendButton.setOnClickListener(this);
        // adapterChat.getListMessage(profile.getUserKey(),);


        //groupId = adapterChat.getGroupId();
        selectPlaceButton = findViewById(R.id.placeButton);
        selectPlaceButton.setOnClickListener(this);
        refreshList();




    }



    public void refreshList() {
        ArrayAdapter<String> chatAdapter = new ArrayAdapter<>(ActivityChat.this,
                android.R.layout.simple_list_item_1,
                chatList.toArray(new String[chatList.size()]));
        listViewChat.setAdapter(chatAdapter);
        //ListMessage listMessage = new ListMessage();
        //listMessage.setChatList(chatList);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sendButton: {
                String messageText = messageArea.getText().toString();
                adapterChat.sendMessage(messageText);
                messageArea.setText("");
                break;
            }

            case R.id.placeButton: {
                AdapterChat.startActivityLocationSelection(this);
                break;
            }
        }
    }


}
