package com.example.wakeparkby.pchell.maveri.Group.GroupListSrc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Group.Group;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class AdapterGroupArray extends ArrayAdapter<Group> {
    private Context mContext;
    private ArrayList<Group> groups = new ArrayList<>();
    public AdapterGroupArray (@NonNull Context context, ArrayList<Group> profileArrayList) {
        super(context, 0, profileArrayList);
        mContext = context;
        groups = profileArrayList;
    }
    public void addAll(ArrayList<Group> items) {
        clear();
        for(Group item :items)
        {
            super.add(item);
        }

        groups=items;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.group_list_row, parent, false);
        Group group =groups.get(position);
        TextView name = (TextView) listItem.findViewById(R.id.name_list_group_row);
        TextView date = (TextView) listItem.findViewById(R.id.date_list_group_row);
        name.setText(group.getName());
        date.setText(group.getDate());
        return listItem;
    }
}
