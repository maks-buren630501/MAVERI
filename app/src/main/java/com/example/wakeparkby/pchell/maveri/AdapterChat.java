package com.example.wakeparkby.pchell.maveri;

import java.util.HashMap;
import java.util.List;

public class AdapterChat {
    public String getId(){
        Profile profile = new Profile();
        return profile.getUserId();
    }

    public void setIdListMessage(String groupId) {
        ListMessage listMessage = new ListMessage();
        listMessage.setId(groupId);
    }

    public void setListMessage(HashMap<String, String> listMessage) {
        ActivityChat activityChat = new ActivityChat();
        activityChat.setListMessage(listMessage);
    }
}
