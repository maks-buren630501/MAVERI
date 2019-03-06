package com.example.wakeparkby.pchell.maveri.Friend;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class FriendListActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
         Bundle bundle=new Bundle();
        ArrayList<Profile> profiles=new ArrayList<>();
        profiles.add(new Profile("ssss"));
        Intent intent=new Intent();
        intent.putExtra("ListProfiles", profiles);
        super.onCreate(savedInstanceState);
        FriendListFragment friendListFragment = new FriendListFragment();

        setContentView(R.layout.activity_friend_list);
    }




}
