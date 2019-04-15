package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Context;
import android.content.Intent;

public class GroupListController {
    public static void startActivityCreateGroup(Context context) {
        Intent intent_createGroup = new Intent(context, ActivityCreateGroup.class);
        context.startActivity(intent_createGroup);
    }
}
