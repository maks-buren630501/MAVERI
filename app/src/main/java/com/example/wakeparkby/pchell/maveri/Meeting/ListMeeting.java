package com.example.wakeparkby.pchell.maveri.Meeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * класс для хранения и обработки списка встреч
 */
public class ListMeeting {

    private ArrayList<Meeting> meetings = new ArrayList<>();


    public void setListMeeting(HashMap<Integer, HashMap<String, String>> listMeetingChat){
        for (Map.Entry entry : listMeetingChat.entrySet()) {
            int key = (int) entry.getKey();
            meetings.add(new Meeting(listMeetingChat.get(key).get("LatLng"),listMeetingChat.get(key).get("PlaceName"),listMeetingChat.get(key).get("Date"),
                    listMeetingChat.get(key).get("UserName"),listMeetingChat.get(key).get("UserKey")));
        }
    }


    /**
     * метод для получения встречи по номеру в списке
     * @param index номер с списке
     * @return встреча по номеру
     */
    public Meeting getMeetingByIndex(int index) {
        return meetings.get(index);
    }

    public ArrayList<Meeting> getMeetings(){
        return  this.meetings;
    }
    /**
     * метод возвращающий размер списка
     * @return размер списка
     */
    public int getSize() {
        return meetings.size();
    }

    /**
     * метод удаляющий встречу из списка по номеру
     * @param index номер встречи в списке
     */
    public void removeMeeting(int index) {
        this.meetings.remove(index);
    }

}
