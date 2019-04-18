package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseGroup;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;

class CreateGroupController {
    public CreateGroupController(String status, String date, String time, String name, String description, String coordinates,String password , Context context, Intent intent) {
        DatabaseGroup databaseGroup = new DatabaseGroup();
        databaseGroup.addNewGroup(status,date,time,name,description,coordinates,password);
    }

    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }
}
