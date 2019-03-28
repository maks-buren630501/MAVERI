package com.example.wakeparkby.pchell.maveri.Meeting;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Meeting {

    private String coordinates;
    private String name;
    private String date;
    private String id;

    public Meeting(HashMap<Integer, HashMap<String, String>> listMeetingChat) {
        for (Map.Entry entry : listMeetingChat.entrySet()) {
             int key = (int) entry.getKey();
            this.name = listMeetingChat.get(key).get("Name");
            this.date = listMeetingChat.get(key).get("Date");
            this.coordinates = listMeetingChat.get(key).get("LatLng");
        }
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }
}
