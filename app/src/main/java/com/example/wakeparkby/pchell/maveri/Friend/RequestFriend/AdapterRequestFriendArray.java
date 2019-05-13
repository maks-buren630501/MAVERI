package com.example.wakeparkby.pchell.maveri.Friend.RequestFriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

class AdapterRequestFriendArray extends ArrayAdapter<RequestFriend> {
    private Context mContext;
    private ArrayList<RequestFriend> requestFriendArrayList= new ArrayList<>();
    public AdapterRequestFriendArray(@NonNull Context context, ArrayList<RequestFriend> profileArrayList) {
        super(context, 0, profileArrayList);
        mContext = context;
        requestFriendArrayList = profileArrayList;
    }
    public void addAll(ArrayList<RequestFriend> items) {
        clear();
        for(RequestFriend item :items)
        {
            super.add(item);
        }

        requestFriendArrayList=items;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.friend_list_row, parent, false);

        RequestFriend currentRequesrFriend= requestFriendArrayList.get(position);

        ImageView imageView = listItem.findViewById(R.id.photo_list_friend_row);
        TextView name = (TextView) listItem.findViewById(R.id.name_list_friend_row);
        name.setText(String.format("%s %s", currentRequesrFriend.getName(), currentRequesrFriend.getLastName()));
    return listItem;
    }
}
