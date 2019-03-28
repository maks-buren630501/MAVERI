package com.example.wakeparkby.pchell.maveri.Friend;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityFriendList extends AppCompatActivity {

    ImageButton searchButton;
    EditText searchRequest;
    @Override
    public void onCreate(Bundle savedInstanceState) {
         Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        searchButton=(ImageButton)findViewById(R.id.search_friend_button);
        searchRequest=(EditText)findViewById(R.id.search_textline);
        FriendListFragment friendListFragment = new FriendListFragment();

    }


    public void onClick(View view) {

        if(!this.searchRequest.getText().toString().isEmpty()) {
            String searchRequest="";
            searchRequest = this.searchRequest.getText().toString();
            DatabaseProfile databaseProfile=new DatabaseProfile();
            databaseProfile.SearchProfile(searchRequest);

        }
    }
}
