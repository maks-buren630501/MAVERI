package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;

import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;

import com.example.wakeparkby.pchell.maveri.Chat.ListMeetingUserOnChat;
import com.example.wakeparkby.pchell.maveri.Chat.ListMessage;
import com.example.wakeparkby.pchell.maveri.Meeting.ListMeeting;
import com.example.wakeparkby.pchell.maveri.Meeting.Meeting;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * класс для связи базы данных со встречами
 */
public class DatabaseMeeting {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeeting;
    private String idUserMeeting;
    HashMap<Integer, HashMap<String, String>> listMeetingChat = new HashMap<>();
    HashMap<Integer, HashMap<String, String>> listMeetingUser = new HashMap<>();
    HashMap<String, String> values;
    ObserverMessage observerMessage = new ObserverMessage("DataBaseMeeting");

    /**
     * метод устанавливающий статус наблюдателя в 5
     */
    //public DatabaseMeeting() {
    //    observerMessage.setStatus(5);
    //}

    /**
     * метод добавляющий встречу в базу данныъх
     *
     * @param userKey
     * @param coordinates координаты
     * @param date        дата
     * @param time        время
     * @param placeName   название
     */
    public void addNewMeetingChat(String userKey, String userName, String coordinates, String date, String time, String placeName) {
        myRefMeeting = database.getReference("Messages/" + Profile.getInstance().getAdapterChat().getGroupId() + "/Meeting/" +
                Profile.getInstance().getUserKey() + "/");
        myRefMeeting.child("UserKey").setValue(userKey);
        myRefMeeting.child("Date").setValue(date + " (" + time + ")");
        myRefMeeting.child("LatLng").setValue(coordinates);
        myRefMeeting.child("PlaceName").setValue(placeName);
        myRefMeeting.child("UserName").setValue(userName);
    }

    /**
     * метод загружающий встречу в чат
     *
     * @param groupId номер чата
     */
    public void loadNewMeetingChat(final String groupId) {
        idUserMeeting = Profile.getInstance().getUserKey();
        myRefMeeting = database.getReference("Messages/" + groupId + "/Meeting/");
        myRefMeeting.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot meetingChatDS) {

                listMeetingChat.clear();
                int fl = 0;
                for (DataSnapshot data : meetingChatDS.getChildren()) {
                    String keyUserId = data.getKey();
                    if (!idUserMeeting.equals(keyUserId)) {
                        values = new HashMap<>();
                        String date = String.valueOf(meetingChatDS.child(keyUserId).child("Date").getValue());
                        String coordinates = String.valueOf(meetingChatDS.child(keyUserId).child("LatLng").getValue());
                        String placeName = String.valueOf(meetingChatDS.child(keyUserId).child("PlaceName").getValue());
                        String userName = String.valueOf(meetingChatDS.child(keyUserId).child("UserName").getValue());
                        String userKey = String.valueOf(meetingChatDS.child(keyUserId).child("UserKey").getValue());
                        values.put("UserKey",userKey);
                        values.put("Date", date);
                        values.put("LatLng", String.valueOf(coordinates));
                        values.put("PlaceName", placeName);
                        values.put("UserName", userName);
                        listMeetingChat.put(fl, values);
                        fl++;
                        // Profile.getInstance().setAdapterChat(new AdapterChat(new ListChatMeeting(listMeetingChat)));

                    }
                }
                Profile.getInstance().getAdapterChat().addListMeetingUserOnChat(new ListMeetingUserOnChat(listMeetingChat));
                //Profile.getInstance().setAdapterChat(new AdapterChat(groupId, new ListMeetingUserOnChat(listMeetingChat)));
                observerMessage.notifyAllObservers(2);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void addNewMeetingUser(String userKey ,String userName, String coordinates, String date, String placeName) {
        myRefMeeting = database.getReference("Users/" + Profile.getInstance().getUserKey() + "/" + "/ListMeeting/").push();
        myRefMeeting.child("UserKey").setValue(userKey);
        myRefMeeting.child("Date").setValue(date);
        myRefMeeting.child("LatLng").setValue(coordinates);
        myRefMeeting.child("PlaceName").setValue(placeName);
        myRefMeeting.child("UserName").setValue(userName);
    }

    public void addNewMeetingInvateUser(String userKey ,String userName, String coordinates, String date, String placeName) {
        myRefMeeting = database.getReference("Users/" + userKey + "/" + "/ListMeeting/").push();
        myRefMeeting.child("UserKey").setValue(userKey);
        myRefMeeting.child("Date").setValue(date);
        myRefMeeting.child("LatLng").setValue(coordinates);
        myRefMeeting.child("PlaceName").setValue(placeName);
        myRefMeeting.child("UserName").setValue(userName);
    }


    public void loadMeetingUser(String userId) {
        idUserMeeting = Profile.getInstance().getUserKey();
        myRefMeeting = database.getReference("Users/" + userId + "/ListMeeting/");
        myRefMeeting.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot meetingChatDS) {
                listMeetingUser.clear();
                int fl = 0;
                for (DataSnapshot data : meetingChatDS.getChildren()) {
                    String keyUserId = data.getKey();
                    if (!idUserMeeting.equals(keyUserId)) {
                        values = new HashMap<>();
                        String date = String.valueOf(meetingChatDS.child(keyUserId).child("Date").getValue());
                        String coordinates = String.valueOf(meetingChatDS.child(keyUserId).child("LatLng").getValue());
                        String placeName = String.valueOf(meetingChatDS.child(keyUserId).child("PlaceName").getValue());
                        String userName = String.valueOf(meetingChatDS.child(keyUserId).child("UserName").getValue());
                        values.put("Date", date);
                        values.put("LatLng", String.valueOf(coordinates));
                        values.put("PlaceName", placeName);
                        values.put("UserName", userName);
                        listMeetingUser.put(fl, values);
                        fl++;
                        // Profile.getInstance().setAdapterChat(new AdapterChat(new ListChatMeeting(listMeetingChat)));
                    }
                }
                Profile.getInstance().getListMeeting().setListMeeting(listMeetingUser);
//                observerMessage.notifyAllObservers(5);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void removeMeetingChat(String invateUserKey) {
        myRefMeeting = database.getReference("Messages/" + Profile.getInstance().getAdapterChat().getGroupId() + "/Meeting/" +
                invateUserKey + "/");
        myRefMeeting.child("UserKey").removeValue();
        myRefMeeting.child("Date").removeValue();
        myRefMeeting.child("LatLng").removeValue();
        myRefMeeting.child("PlaceName").removeValue();
        myRefMeeting.child("UserName").removeValue();
    }
}
