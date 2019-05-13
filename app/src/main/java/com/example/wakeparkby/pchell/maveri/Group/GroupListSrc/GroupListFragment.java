package com.example.wakeparkby.pchell.maveri.Group.GroupListSrc;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Group.Group;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;

import java.util.ArrayList;

public class GroupListFragment extends ListFragment {
    private static  AdapterGroupArray arrayAdapter;
    private ArrayList<Group> groups;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Profile profile=Profile.getInstance();
        groups =profile.getGroups().getGroups();
        arrayAdapter=new AdapterGroupArray(getActivity(), groups);
        setListAdapter(arrayAdapter);
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //получение нажатого значения листа в списке груп
        groups.get(position);
    }
}
