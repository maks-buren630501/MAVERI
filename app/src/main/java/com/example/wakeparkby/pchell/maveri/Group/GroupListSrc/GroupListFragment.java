package com.example.wakeparkby.pchell.maveri.Group.GroupListSrc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Group.ActivityGroup;
import com.example.wakeparkby.pchell.maveri.Group.AdapterGroup;
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


        Group group = groups.get(position);
        AdapterGroup adapterGroup = new AdapterGroup(group);
        Intent intent_group = new Intent(GroupListFragment.this.getActivity(), ActivityGroup.class);
        intent_group.putExtra("groupPassaword",adapterGroup.getGroupPassword());
        intent_group.putExtra("groupName", adapterGroup.getGroupName());
        intent_group.putExtra("groupCoordinates", adapterGroup.getGroupCoordinates());
        intent_group.putExtra("groupDate", adapterGroup.getGroupDate());
        intent_group.putExtra("groupTime", adapterGroup.getGroupTime());
        intent_group.putExtra("groupDescription", adapterGroup.getGroupDescription());
        intent_group.putExtra("numberOfUsers",adapterGroup.getGroupNumberOfUsers());
        startActivity(intent_group);
    }
}
