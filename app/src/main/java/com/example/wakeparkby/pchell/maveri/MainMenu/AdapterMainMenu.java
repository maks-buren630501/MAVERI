package com.example.wakeparkby.pchell.maveri.MainMenu;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.Group.ActivityGroupList;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

/**
 * класс для связи логики гланого меню и объекта интерфейса
 */
public class AdapterMainMenu {
    /**
     * метод создающий объект интерфейса
     * @param context
     */
    protected static void startActivityFriendList(Context context) {
        Intent intent_friend = new Intent(context, ActivityFriendList.class);
        context.startActivity(intent_friend);

    }

    /**
     * метод создающий объект интерфейса профиля
     * @param context
     */
    protected static void startActivityProfile(Context context) {
        Intent intent_profile = new Intent(context, ActivityProfile.class);
        context.startActivity(intent_profile);
    }

    public static void startActivityGroupList(Context context) {
        Intent intent_groupList = new Intent(context, ActivityGroupList.class);
        context.startActivity(intent_groupList);
    }

    public static void startActivitySignIn(Context context) {
        Intent intent_signIn = new Intent(context, ActivitySignIn.class);
        context.startActivity(intent_signIn);
    }
}
