package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;

/**
 * класс для работы с объектом интерфейса выбора даты
 */
public class AdapterMapsDataTime {
    /**
     * конструктор с параметрами
     * @param coordinates координаты
     * @param date дата
     * @param time время
     * @param name название встречи
     */
    public AdapterMapsDataTime(String coordinates, String date, String time, String name) {
        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
        databaseMeeting.addNewMeetingChat(coordinates,date,time,name);
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
