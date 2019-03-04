package com.example.wakeparkby.pchell.maveri;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListMessage {
    private HashMap<String,String> listMessage = new HashMap<>();
    List<String> chatList = new ArrayList<String>();





    public void setId(String groupId) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.setId(groupId);
    }

    public void sendMessage(String id, String name, String time, String message) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.sendMessage(id, name, time, message);
    }

}
