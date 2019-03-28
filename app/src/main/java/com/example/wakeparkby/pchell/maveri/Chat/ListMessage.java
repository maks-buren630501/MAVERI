package com.example.wakeparkby.pchell.maveri.Chat;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListMessage {
    //private HashMap<String,String> listMessage = new HashMap<>();
    List<String> chatList = new ArrayList<String>();

    public ListMessage() {

    }

    public void sendMessage(String name, String time, String message) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.sendMessage(name, time, message);
    }

    public void setGroupId(String groupId) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.loadGroupMessage(groupId);
    }

    public ListMessage(List<String> messages) {
        this.chatList = messages;
    }

    public void setChatList(List<String> chatList) {
        this.chatList = chatList;
    }

    public List<String> getMessages() {
        return this.chatList;
    }
}
