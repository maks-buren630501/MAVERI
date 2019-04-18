package com.example.wakeparkby.pchell.maveri.Friend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;
import java.util.Collection;

/**
 * класс для связи интерфейса и логики списка друзей
 */
public class AdapterFriendArray extends ArrayAdapter<ProfileFriend> {

    private Context mContext;
    private ArrayList<ProfileFriend> profileList = new ArrayList<>();

    /**
     * конструктор с параметрами
     * @param context контекст окна
     * @param profileArrayList список друзей для вывода
     */
    public AdapterFriendArray(@NonNull Context context, ArrayList<ProfileFriend> profileArrayList) {
        super(context, 0, profileArrayList);
        mContext = context;
        profileList = profileArrayList;
    }


    /**
     * метод для вывода списка друзей на экран
     * @param items список друзей
     */
    public void addAll(ArrayList<ProfileFriend> items) {
        clear();
        for(ProfileFriend item :items)
        {
            super.add(item);
        }

        profileList=items;
        notifyDataSetChanged();
    }

    /**
     * метод для вывода 1 друга на экран
     * @param object профиль друга
     */
    @Override
    public void add( @Nullable ProfileFriend object) {
      //  super.add(object);
        profileList.add(object);
        notifyDataSetChanged();
    }

    /**
     * метод для очистки списка на экране
     */
    @Override
    public void clear() {
        super.clear();
        profileList.clear();
        notifyDataSetChanged();

    }

    /**
     * метод для удаления 1 друга из списка
     * @param object удаляемый друг
     */
    @Override
    public void remove( @Nullable ProfileFriend object) {
        super.remove(object);
        profileList.remove(object);
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.friend_list_row, parent, false);

        ProfileFriend currentProfile = profileList.get(position);

        ImageView imageView = listItem.findViewById(R.id.photo_list_friend_row);
        TextView name = (TextView) listItem.findViewById(R.id.name_list_friend_row);
        name.setText(String.format("%s %s", currentProfile.getFirstName(), currentProfile.getLastName()));

        return listItem;
    }

    public void update() {
        notifyDataSetChanged();
    }
}
