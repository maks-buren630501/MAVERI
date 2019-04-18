package com.example.wakeparkby.pchell.maveri.Chat;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;

import java.util.HashMap;

/**
 * класс для хранения и обработки списка сообщений пользователей в чате
 */
public class ListMeetingUserOnChat {
    HashMap<Integer, HashMap<String, String>> listMeetingChat = new HashMap<>();
    public ListMeetingUserOnChat(HashMap<Integer, HashMap<String, String>> listMeetingChat) {
        this.listMeetingChat = listMeetingChat;
    }

    /**
     * пустой конструктор
     */
    public ListMeetingUserOnChat() {
    }

    /**
     * метод для вызова встречи из базы данных
     * @param groupId номер встречи
     */
    public void loadMeeting(String groupId) {
        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
        databaseMeeting.loadNewMeetingChat(groupId);
    }

    /**
     * метод возвращающий список сообщений
     * @return метод возвращающий список сообщений
     */
    public HashMap<Integer, HashMap<String, String>> getListMeetingChat() {
        return listMeetingChat;
    }
}
