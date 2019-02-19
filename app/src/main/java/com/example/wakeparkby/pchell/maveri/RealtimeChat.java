package com.example.wakeparkby.pchell.maveri;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RealtimeChat extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMessage = database.getReference("Messeges");
    private Button bUserOnline;
    private Button bSend;
    private EditText etText;
    private ListView lvChat;
    private String msg;
    private String timeMessage;
    private String autor;
    private String userKey;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime_chat);
        bSend = (Button) findViewById(R.id.buttonSend);
        bSend.setOnClickListener((View.OnClickListener) this);
        etText = (EditText) findViewById(R.id.editTextText);
        lvChat = (ListView) findViewById(R.id.listViewChat);
        chatListRefresh();
    }

    private void chatListRefresh() {
        //-----Отображение в базе данных сообщений
        myRefMessage.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot chatDS) {
                final List<String> chatList = new ArrayList<String>();
                for (DataSnapshot battle : chatDS.getChildren())
                    chatList.add((String) battle.getValue());
                ArrayAdapter<String> chatAdapter = new ArrayAdapter<>(RealtimeChat.this,
                        android.R.layout.simple_list_item_1,
                        chatList.toArray(new String[chatList.size()]));
                lvChat.setAdapter(chatAdapter);
                lvChat.deferNotifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSend:
                msg = etText.getText().toString();
                if (msg.equals("")) {
                    Toast.makeText(RealtimeChat.this, "Введите текст сообщения !!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RealtimeChat.this, "Отправлено !!!", Toast.LENGTH_SHORT).show();
                    etText.setText("");
                    send_msg();
                    //userKey = mAuth.getCurrentUser().getUid();
                    //-----Получаем имя из списка Users по KEY (личному)
                    /*myRefUsers.child(userKey).addListenerForSingleValueEvent(
                            new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    autor = (String) dataSnapshot.getValue();
                                    send_msg();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    // Getting Post failed, log a message
                                }
                            });*/
                }
        }
    }

    //-----Отправка сообщения в базу данных
    public void send_msg() {
        //----- Установка времени и даты отправки сообщения
        DateFormat df = new SimpleDateFormat(" HH:mm (dd.MM.yyyy)");
        timeMessage = df.format(Calendar.getInstance().getTime());
        String autorTime = (autor + "      " + timeMessage + System.lineSeparator());
        myRefMessage.push().setValue(autorTime + msg);
        chatListRefresh();

    }
}
