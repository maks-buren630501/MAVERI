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
    private AdapterFriendArray arrayAdapter;
    private ArrayList<ProfileFriend> profilesList;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
      //  ArrayList<Profile> profiles=getArguments().getParcelable("ListProfiles");
        super.onActivityCreated(savedInstanceState);

         }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Profile profile = Profile.getInstance();
        profilesList = profile.getAdapterFriendList().getFriends();
      //  AdapterFriendList adapterFriendList=new AdapterFriendList();
     //   profiles=adapterFriendList.getFriends();
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
       // super.onListItemClick(l, v, position, id);
       //Toast.makeText(getActivity(), "Вы выбрали позицию: " + position, Toast.LENGTH_SHORT).show();
        ActivityProfileFriend activityProfileFriend = new ActivityProfileFriend(adapterProfileFriend);
        Intent intent_friendProfile = new Intent(FriendListFragment.this.getActivity(),ActivityProfileFriend.class);
        //intent_friendProfile.putExtra("Id",profiles.get(position).getUserId());
        startActivity(intent_friendProfile);

    }



}
