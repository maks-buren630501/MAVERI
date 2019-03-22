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


    Button chat;
    TextView name;
    TextView interest;
    //ArrayList<String> Spisok;
   // private String userKey ;
    AdapterProfileFriend adapterProfileFriend;

    public ActivityProfileFriend(AdapterProfileFriend adapterProfileFriend) {
        this.adapterProfileFriend = adapterProfileFriend;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //int id=savedInstanceState.getInt("Id");
        setContentView(R.layout.activity_friend_info);
        name=findViewById(R.id.namefriendinfo);
        interest=findViewById(R.id.infintfriendinfo);
        //Spisok=new ArrayList<>();
        chat=findViewById(R.id.monbutfriendinfo);
        chat.setOnClickListener(this);
        name.setText(String.format("%s %s", adapterProfileFriend.getUserFirstName(), adapterProfileFriend.getUserLastName()));
        interest.setText(adapterProfileFriend.getUserListInterests());
        //userKey = adapterProfileFriend.getUserKey();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.monbutfriendinfo:{

                adapterProfileFriend.startActivityChat(this);
            }
        }
    }
}
