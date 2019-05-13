package com.example.wakeparkby.pchell.maveri.Friend.RequestFriend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;

import java.util.ArrayList;

public class RequestListFragment extends ListFragment {
    private static  AdapterRequestFriendArray arrayAdapter;
    private ArrayList<RequestFriend> requestFriends;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Profile profile=Profile.getInstance();
        requestFriends=profile.getReqestFriend().getReqest();
        arrayAdapter=new AdapterRequestFriendArray(getActivity(), requestFriends);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //получение нажатого значения листа в списке запросов
        requestFriends.get(position);
    }
}
