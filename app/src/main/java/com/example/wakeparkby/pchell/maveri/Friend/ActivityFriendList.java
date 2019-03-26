package com.example.wakeparkby.pchell.maveri.Friend;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityFriendList extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        FriendListFragment friendListFragment = new FriendListFragment();
        setContentView(R.layout.activity_friend_list);
    }


}
