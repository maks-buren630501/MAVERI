package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMessage;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityLocationSelection;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

import java.text.SimpleDateFormat;
import java.util.Date;
public class AdapterChat {

    private String groupId;
    ListMessage listMessage = new ListMessage();
    DatabaseMessage databaseMessage = new DatabaseMessage();

    public AdapterChat(String userKey, String userKey1) {
        if (userKey.hashCode() > userKey1.hashCode()) {
            groupId = userKey.concat(userKey1);
        } else if (userKey1.hashCode() > userKey.hashCode()) {
            groupId = userKey1.concat(userKey);
        } else if (userKey1.hashCode() == userKey.hashCode()) {
            groupId = userKey1.concat(userKey);
        }
        listMessage.setGroupId(groupId);

    }

    public AdapterChat() {
    }

    public String getGroupId() {
        return groupId;
    }

    public void sendMessage(String messageText){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy(E) hh:mm:ss");
        String time = formatForDateNow.format(dateNow);
      //  Profile profile = new Profile();
     //   profile.getFirstName();
        ListMessage listMessage = new ListMessage();
    //    listMessage.sendMessage(profile.getFirstName(),time ,messageText);
    }

    protected static void startActivityLocationSelection(Context context) {
        Intent intent_selectPlace = new Intent(context, ActivityLocationSelection.class);
        context.startActivity(intent_selectPlace);
    }
}
