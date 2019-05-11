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
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

/**
 * класс для объекта интерфейса списка друзей
 */
public class ActivityFriendList extends AppCompatActivity {

    ImageButton searchButton;
    boolean searchButtonRes;
    EditText searchRequest;
    FriendListFragment friendListFragment;
    @Override
    /**
     * стандартный метод создания объекта интерфейса
     */
    public void onCreate(Bundle savedInstanceState) {
         Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        searchButtonRes=false;
        setContentView(R.layout.activity_friend_list);
        searchButton=(ImageButton)findViewById(R.id.search_friend_button);
        searchRequest=(EditText)findViewById(R.id.search_textline);
        friendListFragment = new FriendListFragment();

    }


    /**
     * метод для обработки нажатий
     * @param view статус нажатия
     */
    public void onClick(View view) {
        if (!searchButtonRes) {
            searchButtonRes=true;
            if (!this.searchRequest.getText().toString().isEmpty()) {
                String searchRequest = "";
                searchRequest = this.searchRequest.getText().toString();
                DatabaseProfile databaseProfile = new DatabaseProfile();
                databaseProfile.SearchProfile(searchRequest);

            }
        }
        else{
            searchButtonRes=false;
            Profile profile = Profile.getInstance();
            friendListFragment.setProfilesList((ArrayList<ProfileFriend>) profile.getAdapterFriendList().getFriends().clone());
        }
    }
}
