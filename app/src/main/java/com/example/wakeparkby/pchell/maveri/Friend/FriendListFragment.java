package com.example.wakeparkby.pchell.maveri.Friend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FriendListFragment extends ListFragment {
    private FriendArrayAdapter arrayAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
         super.onActivityCreated(savedInstanceState);
         }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Profile> profiles=new ArrayList<>();

        arrayAdapter   =new FriendArrayAdapter(getActivity(),profiles);
        if(!profiles.isEmpty())
        setListAdapter(arrayAdapter);

        View view=inflater.inflate(R.layout.listfragment,container,false);
        return view;
    }
    //обработка нажатия на профиль
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
       Toast.makeText(getActivity(), "Вы выбрали позицию: " + position, Toast.LENGTH_SHORT).show();
    }


}
