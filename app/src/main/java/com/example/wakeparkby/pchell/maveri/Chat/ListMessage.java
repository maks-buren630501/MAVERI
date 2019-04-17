package com.example.wakeparkby.pchell.maveri.Chat;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;
import com.example.wakeparkby.pchell.maveri.Database.DatabaseMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * класс хранящий список сообщений
 */
public class ListMessage {
    //private HashMap<String,String> listMessage = new HashMap<>();
    List<String> chatList = new ArrayList<String>();

    /**
     * пустой конструктор
     */
    public ListMessage() {

    }

    /**
     * метод для добавления сообщения в список
     * @param name имя отправителя
     * @param time время отправки
     * @param message текст сообщения
     */
    public void sendMessage(String name, String time, String message) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.sendMessage(name, time, message);
    }

    /**
     * метод для устоановки общего номера пользователей
     * @param groupId общий номер
     */
    public void setGroupId(String groupId) {
        DatabaseMessage databaseMessage = new DatabaseMessage();
        databaseMessage.loadGroupMessage(groupId);
    }

    /**
     * конструктор с параметром
     * @param messages список сообщений
     */
    public ListMessage(List<String> messages) {
        this.chatList = messages;
    }

    /**
     * метод для установки чата(списка текстовых сообщений)
     * @param chatList спислк текстовых сообщений
     */
    public void setChatList(List<String> chatList) {
        this.chatList = chatList;
    }

    /**
     *  метод возвращающий список текстовых сообщений
     * @return список текстовых сообщений
     */
    public List<String> getMessages() {
        return this.chatList;
    }
}
