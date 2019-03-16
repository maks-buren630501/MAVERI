package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityLocationSelection;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;

import java.text.SimpleDateFormat;
import java.util.Date;
public class AdapterChat {

    private String userKey;
    private String friendUserKey;
    private String groupId;
    private Profile profile = Profile.getInstance();

    public void getListMessage(String userKey, String friendUserKeyd){

        this.userKey = userKey;
        this.friendUserKey = friendUserKeyd;
        if (userKey.hashCode() > friendUserKey.hashCode()) {
            groupId = userKey.concat(friendUserKey);
        } else if (friendUserKey.hashCode() > userKey.hashCode()) {
            groupId = friendUserKey.concat(userKey);
        } else if (userKey.hashCode() == friendUserKey.hashCode()) {
            groupId = userKey.concat(friendUserKey);
        }
        ListMessage listMessage = new ListMessage();
        listMessage.setId(groupId);
    }

    public String getGroupId() {
        return groupId;
    }

    public void sendMessage(String messageText){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy(E) hh:mm:ss");
        String time = formatForDateNow.format(dateNow);
        profile.getFirstName();
        ListMessage listMessage = new ListMessage();
        listMessage.sendMessage(profile.getFirstName(),time ,messageText);
    }

    protected static void startActivityLocationSelection(Context context) {
        Intent intent_selectPlace = new Intent(context, ActivityLocationSelection.class);
        context.startActivity(intent_selectPlace);
    }
}
