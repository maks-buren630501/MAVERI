package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;

/**
 * класс для работы с объектом интерфейса выбора даты
 */
public class AdapterMapsDataTime {
    /**
     * конструктор с параметрами
     * @param coordinates координаты
     * @param date дата
     * @param time время
     * @param PlaceName название встречи
     */
    public AdapterMapsDataTime(String coordinates, String date, String time, String PlaceName) {
        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
        databaseMeeting.addNewMeetingChat(Profile.getInstance().getUserKey(),Profile.getInstance().getFirstName(),coordinates,date,time,PlaceName);
    }

    /**
     * стандартный метод для создания android activity
     * @param context
     * @param intent
     */
    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }
}
