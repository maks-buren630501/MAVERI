package com.example.wakeparkby.pchell.maveri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityChat extends AppCompatActivity {
   // private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private ListView listView;
    private View btnSend;
    private static EditText editText;
    boolean myMessage = true; //false - мое сообщение , true - пользователя
    private List<ChatBubble> ChatBubbles = new ArrayList<>();
    private static ArrayAdapter<ChatBubble> adapter;
    private String userKey = "userKey";// mAuth.getCurrentUser().getUid();
    private String userId;
    private String groupId;
    private HashMap <String,String> listMessages = new HashMap<>();
    AdapterChat adapterChat = new AdapterChat();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //ChatBubbles = new ArrayList<>();
        listView = findViewById(R.id.list_msg);
        btnSend = findViewById(R.id.btn_chat_send);
        editText = findViewById(R.id.msg_type);



        userId = adapterChat.getId();
        if (userKey.hashCode()>userId.hashCode()){
            groupId = userKey.concat(userId);
        }
        else if (userId.hashCode()>userKey.hashCode()){
            groupId = userId.concat(userKey);
        }
        else if (userKey.hashCode()==userId.hashCode()){
            groupId = userKey.concat(userId);
        }
        adapterChat.setIdListMessage(groupId);
        adapter = new MessageAdapter(this, R.layout.left_chat_bubble, ChatBubbles);
        listView.setAdapter(adapter);
        //set ListView adapter first
        /*adapter = new MessageAdapter(this, R.layout.left_chat_bubble, ChatBubbles);
        listView.setAdapter(adapter);

        //event for button SEND
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(ActivityChat.this, "Введите сообщение...", Toast.LENGTH_SHORT).show();
                } else {
                    //add message to list
                    ChatBubble ChatBubble = new ChatBubble(editText.getText().toString(), myMessage);
                    ChatBubbles.add(ChatBubble);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    myMessage = !myMessage;
                }
            }
        });*/
    }
    public void setListMessage(HashMap<String, String> listMessage){
        this.listMessages = listMessage;
       // if(!listMessage.equals(null)){
            for (Map.Entry entry : listMessages.entrySet()) {
                if (entry.getKey().equals(userKey))
                {
                    String a = String.valueOf(entry.getValue());
                    ChatBubble ChatBubble = new ChatBubble(a, myMessage);
                    ChatBubbles.add(ChatBubble);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
                else
                {
                    myMessage = !myMessage;
                    ChatBubble ChatBubble = new ChatBubble((String) entry.getValue(), myMessage);
                    ChatBubbles.add(ChatBubble);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
       // }

    }

}