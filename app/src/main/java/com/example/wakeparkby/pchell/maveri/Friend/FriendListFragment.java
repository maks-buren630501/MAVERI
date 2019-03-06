package com.example.wakeparkby.pchell.maveri.Friend;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class FriendListFragment extends ListFragment {
    private FriendArrayAdapter arrayAdapter;
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
        arrayAdapter = new FriendArrayAdapter(getActivity(), profiles);
        setListAdapter(arrayAdapter);
        View view = inflater.inflate(R.layout.listfragment, container, false);
        return view;
    }
        //обработка нажатия на профиль
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
       Toast.makeText(getActivity(), "Вы выбрали позицию: " + position, Toast.LENGTH_SHORT).show();
    }



}
