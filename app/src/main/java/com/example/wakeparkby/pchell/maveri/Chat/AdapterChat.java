package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityLocationSelection;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;

import java.text.SimpleDateFormat;
import java.util.Date;
public class AdapterChat extends AppCompatActivity {

    private String userKey;
    private String userId;
    private String groupId;


    public void getListMessage(){
        Profile profile = new Profile();
        this.userId = profile.getUserId();
        this.userKey = profile.getUserKey();
        if (userKey.hashCode() > userId.hashCode()) {
            groupId = userKey.concat(userId);
        } else if (userId.hashCode() > userKey.hashCode()) {
            groupId = userId.concat(userKey);
        } else if (userKey.hashCode() == userId.hashCode()) {
            groupId = userKey.concat(userId);
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
        Profile profile = new Profile();
        profile.getFirstName();
        ListMessage listMessage = new ListMessage();
        listMessage.sendMessage(profile.getFirstName(),time ,messageText);
    }

    protected void startActivityLocationSelection() {
        Intent intent_selectPlace = new Intent(this, ActivityLocationSelection.class);
        startActivity(intent_selectPlace);
    }
}
