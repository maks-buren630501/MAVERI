package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityMaps;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * класс для связилогики чата с интерфейсом
 */
public class AdapterChat {

    private String groupId;
    ListMessage listMessage = new ListMessage();
    ListMeetingUserOnChat listMeetingUserOnChat = new ListMeetingUserOnChat();
    //DatabaseMessage databaseMessage = new DatabaseMessage();

    /**
     * конструктор с параметрами
     * @param userKey номер 1 пользователя
     * @param userKey1 номер 2 пользователя с которым ведем переписку
     */
    public AdapterChat(String userKey, String userKey1) {
        if (userKey.hashCode() > userKey1.hashCode()) {
            groupId = userKey.concat(userKey1);
        } else if (userKey1.hashCode() > userKey.hashCode()) {
            groupId = userKey1.concat(userKey);
        } else if (userKey1.hashCode() == userKey.hashCode()) {
            groupId = userKey1.concat(userKey);
        }
        listMessage.setGroupId(groupId);
        listMeetingUserOnChat.loadMeeting(groupId);
    }

    /**
     * конструктор с параметрами
     * @param groupId общий номер 2-х пользователей
     * @param listMessage список сообщений
     */
    public AdapterChat(String groupId, ListMessage listMessage) {
        this.groupId = groupId;
        this.listMessage = listMessage;
    }

    /**
     * конструктор с параметрами
     * @param groupId общий номер 2-х пользователей
     * @param listMeetingUserOnChat спсиок сообщений пользователей в чате
     */
    public AdapterChat(String groupId, ListMeetingUserOnChat listMeetingUserOnChat) {
        this.groupId = groupId;
        this.listMeetingUserOnChat = listMeetingUserOnChat;
    }

    /**
     * пустой конструктор
     */
    public AdapterChat() {
    }

    /**
     * метод для выбора места на ккарте
     * @param context контекс для создания activity
     * @param latLng координаты
     */
    public static void pickPositionOnMap(Context context, LatLng latLng) {
        Intent intent_map = new Intent(context, ActivityMaps.class);
        context.startActivity(intent_map);
        ActivityMaps activityMaps = new ActivityMaps();
    }


    /**
     * метод возвращающий групповой номер
     * @return групповой номер
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * метод для отправки сообщения
     * @param messageText текст отправляемого сообщения
     */
    public void sendMessage(String messageText) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy(E) hh:mm:ss");
        String time = formatForDateNow.format(dateNow);
        //  Profile profile = new Profile();
        //   profile.getFirstName();

        ListMessage listMessage = new ListMessage();
        listMessage.sendMessage(Profile.getInstance().getFirstName(), time, messageText);
    }

    /**
     * метод для старта активити выбора места встречи
     * @param context базовый парметр java
     * @param coordinates координаты в текстовом виде
     */
    protected static void startActivityMeetingOnMaps(Context context, String coordinates) {
        Intent intent_meetingOnMaps = new Intent(context, ActivityMaps.class);
        intent_meetingOnMaps.putExtra("coordinates",coordinates);
        context.startActivity(intent_meetingOnMaps);
    }

    /**
     * метод для открытия карты
     * @param context базовый параметр java
     */
    public static void startActivityMap(Context context) {
        Intent intent_maps = new Intent(context, ActivityMaps.class);
        context.startActivity(intent_maps);
    }

    /**
     * метод возвращающий список сообщений
     * @return список сообщений
     */
    public ListMessage getListMessage() {
        return listMessage;
    }

    /**
     * метод возвращающий список сообщений пользователей в чате
     * @return список сообщений пользователей в чате
     */
    public ListMeetingUserOnChat getlistMeetingChat() {
        return listMeetingUserOnChat;
    }

    public void addListMeetingUserOnChat(ListMeetingUserOnChat listMeetingUserOnChat) {
        this.groupId = groupId;
        this.listMeetingUserOnChat = listMeetingUserOnChat;
    }
}
