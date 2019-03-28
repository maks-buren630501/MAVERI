package com.example.wakeparkby.pchell.maveri.Chat;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;

import java.util.HashMap;

public class ListMeetingUserOnChat {
    HashMap<Integer, HashMap<String, String>> listMeetingChat = new HashMap<>();
    public ListMeetingUserOnChat(HashMap<Integer, HashMap<String, String>> listMeetingChat) {
        this.listMeetingChat = listMeetingChat;
    }

    public ListMeetingUserOnChat() {
    }

    public void loadMeeting(String groupId) {
        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
        databaseMeeting.loadNewMeetingChat(groupId);
    }

    public HashMap<Integer, HashMap<String, String>> getListMeetingChat() {
        return listMeetingChat;
    }
}
