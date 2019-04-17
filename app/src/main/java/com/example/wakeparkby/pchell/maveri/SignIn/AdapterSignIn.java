package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.AnimationLoad;
import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendList;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * класс для связи логики входа с интерфейсом
 */
public class AdapterSignIn {
    Profile profile;

    /**
     * пустой конструктор
     */
    public AdapterSignIn() {
    }

    ;

    /**
     * конструктор с параметрами
     * @param userId номер пользователя
     * @param firstName имя
     * @param lastName фамилия
     * @param age возрост
     * @param sex пол
     * @param listInterests список интересов
     */
    public AdapterSignIn(String userId, String firstName, String lastName, String age, String sex, String listInterests) {
        profile.getInstanceWithParam(userId, firstName, lastName, age, sex, listInterests);
    }

    /**
     * метод для загрузки информации о пользователе и базы данных
     * @param userId
     */
    public void loadUserInfo(String userId) {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.loadUserInfo(userId);
    }

    /**
     * метод для создания объекта интерфейса загрузки
     * @param context стандартный параметр
     */
    public static void startActivityLoad(Context context) {
        //  Intent intent_Main_Menu = new Intent(context, ActivityFriendList.class);
        Intent intent_Load = new Intent(context, AnimationLoad.class);
        context.startActivity(intent_Load);

    }
}
