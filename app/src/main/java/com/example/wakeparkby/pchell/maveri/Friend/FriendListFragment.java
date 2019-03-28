package com.example.wakeparkby.pchell.maveri.Friend;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfileFriend;
import com.example.wakeparkby.pchell.maveri.Profile.AdapterProfile;
import com.example.wakeparkby.pchell.maveri.Profile.AdapterProfileFriend;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FriendListFragment extends ListFragment {
    private static  AdapterFriendArray arrayAdapter;
    private ArrayList<ProfileFriend> profilesList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public static  AdapterFriendArray getArrayAdapter() {
        return arrayAdapter;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Profile profile = Profile.getInstance();
        profilesList = profile.getAdapterFriendList().getFriends();
        arrayAdapter = new AdapterFriendArray(getActivity(), profilesList);
        setListAdapter(arrayAdapter);
        View view = inflater.inflate(R.layout.listfragment, container, false);
        return view;
    }




    //обработка нажатия на профиль
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        ProfileFriend friend = profilesList.get(position);
        AdapterProfileFriend adapterProfileFriend = new AdapterProfileFriend(friend);
        Intent intent_friendProfile = new Intent(FriendListFragment.this.getActivity(), ActivityProfileFriend.class);
        intent_friendProfile.putExtra("userFirstName", adapterProfileFriend.getUserFirstName());
        intent_friendProfile.putExtra("userLastName", adapterProfileFriend.getUserLastName());
        intent_friendProfile.putExtra("userListInterests", adapterProfileFriend.getUserListInterests());
        intent_friendProfile.putExtra("userId", adapterProfileFriend.getUserId());
        intent_friendProfile.putExtra("userAge", adapterProfileFriend.getUserAge());
        intent_friendProfile.putExtra("userSex", adapterProfileFriend.getUserSex());


        startActivity(intent_friendProfile);

    }


}
