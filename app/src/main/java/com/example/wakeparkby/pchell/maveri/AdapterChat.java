package com.example.wakeparkby.pchell.maveri;

import android.widget.ArrayAdapter;

import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AdapterChat {

    //private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userKey = "userKey";// mAuth.getCurrentUser().getUid();
    private String userId;
    private String groupId;


    public void getListMessage() {
        Profile profile = new Profile();
        this.userId = profile.getUserId();
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
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.sendMessage(userKey, profile.getFirstName(),time ,messageText);
    }
}
