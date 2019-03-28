package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;

public class AdapterMapsDataTime {
    public AdapterMapsDataTime(String coordinates, String date, String time, String name) {
        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
        databaseMeeting.addNewMeetingChat(coordinates,date,time,name);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }
}
