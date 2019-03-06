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

import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfileFriend;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class FriendListFragment extends ListFragment {
    private AdapterFriendArray arrayAdapter;
    private ArrayList<ContactsContract.Profile> profiles;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
      //  ArrayList<Profile> profiles=getArguments().getParcelable("ListProfiles");
        super.onActivityCreated(savedInstanceState);

         }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Profile> profiles = new ArrayList<>();
        profiles.add(new Profile("Slava GoldFish"));
        arrayAdapter = new AdapterFriendArray(getActivity(), profiles);
        setListAdapter(arrayAdapter);
        View view = inflater.inflate(R.layout.listfragment, container, false);
        return view;
    }
        //обработка нажатия на профиль
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
       // super.onListItemClick(l, v, position, id);
       //Toast.makeText(getActivity(), "Вы выбрали позицию: " + position, Toast.LENGTH_SHORT).show();
        Intent intent_friendProfile = new Intent(FriendListFragment.this.getActivity(),ActivityProfileFriend.class);
        startActivity(intent_friendProfile);

    }



}
