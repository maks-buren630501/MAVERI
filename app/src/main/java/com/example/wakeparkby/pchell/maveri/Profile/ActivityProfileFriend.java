package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

/**
 * класс для работы с объектом интерфейса профиля друга
 */
public class ActivityProfileFriend extends AppCompatActivity implements View.OnClickListener {
    Button chat;
    TextView name;
    TextView interest;
    Button friend;

    /**
     * стандартный метод создания android
     * @param savedInstanceState стандартный параметр
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        name = findViewById(R.id.namefriendinfo);
        interest = findViewById(R.id.infintfriendinfo);
        chat = findViewById(R.id.mesbutfriendinfo);
        chat.setOnClickListener(this);
        name.setText(String.format("%s %s", getIntent().getStringExtra("userFirstName"), getIntent().getStringExtra("userLastName")));
        interest.setText(getIntent().getStringExtra("userListInterests"));
        TabHost tabHostfriend = (TabHost) findViewById(R.id.FriendInformation);

        tabHostfriend.setup();

        TabHost.TabSpec tabSpecfriend = tabHostfriend.newTabSpec("tag1friend");

        tabSpecfriend.setContent(R.id.tab1friendinfo);
        tabSpecfriend.setIndicator("Баланс");
        tabHostfriend.addTab(tabSpecfriend);

        tabSpecfriend = tabHostfriend.newTabSpec("tag2friend");
        tabSpecfriend.setContent(R.id.tab2friendinfo);
        tabSpecfriend.setIndicator("О себе");
        tabHostfriend.addTab(tabSpecfriend);

        tabSpecfriend = tabHostfriend.newTabSpec("tag3friend");
        tabSpecfriend.setContent(R.id.tab3friendinfo);
        tabSpecfriend.setIndicator("Встречи");
        tabHostfriend.addTab(tabSpecfriend);

        tabHostfriend.setCurrentTab(0);

        friend = findViewById(R.id.meetbutfriendinfo);
        int fl = 0;
        for (int i = 0; i < Profile.getInstance().getAdapterFriendList().getFriends().size(); i++ ){
            if(Profile.getInstance().getAdapterFriendList().getFriends().get(i).getUserKey().equals(getIntent().getStringExtra("userId"))){
                fl = 1 ;
            }
        }
        if (fl == 1 ){
            friend.setBackgroundResource(R.drawable.buttonmeeting_no);

        }
        else {
            Toast.makeText(this, "НЕТ В ДРУЗЬЯХ", Toast.LENGTH_SHORT).show();
            friend.setBackgroundResource(R.drawable.buttonmeeting);
        }
    }
    /**
     * метод для обработки нажатий
     * @param v статус нажатия
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mesbutfriendinfo: {
                AdapterProfileFriend adapterProfileFriend = new AdapterProfileFriend(getIntent().getStringExtra("userId"),
                        getIntent().getStringExtra("userFirstName"), getIntent().getStringExtra("userLastName"),
                        getIntent().getStringExtra("userAge"), getIntent().getStringExtra("userSex"), getIntent().getStringExtra("userListInterests"));
                adapterProfileFriend.startActivityChat(getIntent().getStringExtra("userFirstName") ,this);
            }
        }
    }
}
