package com.example.wakeparkby.pchell.maveri.Chat;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        ListMessage listMessage = new ListMessage();
        listMessage.sendMessage(profile.getFirstName(),time ,messageText);
    }
}
