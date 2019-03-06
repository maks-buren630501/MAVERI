package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfileFriend extends AppCompatActivity implements View.OnClickListener{


    ImageButton imageButtonBack;
    Button chat;
    TextView name;
    TextView interest;
    ArrayList<String> Spisok;
    private String userKey = "RE1nc7WIxKRS3fDGOOPtnw1PA9b2";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        name=findViewById(R.id.namefriendinfo);
        interest=findViewById(R.id.infintfriendinfo);
        Spisok=new ArrayList<>();
        imageButtonBack=findViewById(R.id.iButtonBackfriendinfo);
        imageButtonBack.setOnClickListener(this);
        chat=findViewById(R.id.monbutfriendinfo);
        chat.setOnClickListener(this);

        Spisok.add("Хоккей");

        name.setText("Alex Rimash");
        interest.setText( Spisok.get(Spisok.size() - 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iButtonBackfriendinfo:{
                Intent intent_MainMenu = new Intent(this, ActivityMainMenu.class);
                startActivity(intent_MainMenu);
                break;
            }
            case R.id.monbutfriendinfo:{
                AdapterProfileFriend adapterProfileFriend = new AdapterProfileFriend(userKey);
                Intent intent_Chat = new Intent(this, ActivityChat.class);
                startActivity(intent_Chat);
            }
        }
    }
}
