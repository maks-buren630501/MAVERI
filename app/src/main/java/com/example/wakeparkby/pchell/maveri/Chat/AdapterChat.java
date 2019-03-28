package com.example.wakeparkby.pchell.maveri.Chat;

import android.content.Context;
import android.content.Intent;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityMaps;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.maps.model.LatLng;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdapterChat {

    private String groupId;
    ListMessage listMessage = new ListMessage();
    ListMeetingUserOnChat listMeetingUserOnChat = new ListMeetingUserOnChat();
    //DatabaseMessage databaseMessage = new DatabaseMessage();

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

    public AdapterChat(String groupId, ListMessage listMessage) {
        this.groupId = groupId;
        this.listMessage = listMessage;
    }

    public AdapterChat(String groupId, ListMeetingUserOnChat listMeetingUserOnChat) {
        this.groupId = groupId;
        this.listMeetingUserOnChat = listMeetingUserOnChat;
    }

    public AdapterChat() {
    }

    public static void pickPositionOnMap(Context context, LatLng latLng) {
        Intent intent_map = new Intent(context, ActivityMaps.class);
        context.startActivity(intent_map);
        ActivityMaps activityMaps = new ActivityMaps();
    }


    public String getGroupId() {
        return groupId;
    }

    public void sendMessage(String messageText) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy(E) hh:mm:ss");
        String time = formatForDateNow.format(dateNow);
        //  Profile profile = new Profile();
        //   profile.getFirstName();

        ListMessage listMessage = new ListMessage();
        listMessage.sendMessage(Profile.getInstance().getFirstName(), time, messageText);
    }

    protected static void startActivityMeetingOnMaps(Context context, String coordinates) {
        Intent intent_meetingOnMaps = new Intent(context, ActivityMaps.class);
        intent_meetingOnMaps.putExtra("coordinates",coordinates);
        context.startActivity(intent_meetingOnMaps);
    }

    public static void startActivityMap(Context context) {
        Intent intent_maps = new Intent(context, ActivityMaps.class);
        context.startActivity(intent_maps);
    }

    public ListMessage getListMessage() {
        return listMessage;
    }

    public ListMeetingUserOnChat getlistMeetingChat() {
        return listMeetingUserOnChat;
    }

}
