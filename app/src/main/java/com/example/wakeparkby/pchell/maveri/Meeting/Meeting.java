package com.example.wakeparkby.pchell.maveri.Meeting;

import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * класс для работы с встречей
 */
public class Meeting {

    private String coordinates;
    private String name;
    private String date;
    private String id;

    /**
     * конструктор с параметрами
     * @param listMeetingChat спсок встреч из чата
     */
    public Meeting(HashMap<Integer, HashMap<String, String>> listMeetingChat) {
        for (Map.Entry entry : listMeetingChat.entrySet()) {
             int key = (int) entry.getKey();
            this.name = listMeetingChat.get(key).get("Name");
            this.date = listMeetingChat.get(key).get("Date");
            this.coordinates = listMeetingChat.get(key).get("LatLng");
        }
    }

    /**
     * метод возвращающий координаты встречи
     * @return координаты встречи
     */
    public String getCoordinates() {
        return coordinates;
    }
    /**
     * метод возвращающий название встречи
     * @return координаты название
     */
    public String getName() {
        return name;
    }
    /**
     * метод возвращающий дату встречи
     * @return дату встречи
     */
    public String getDate() {
        return date;
    }
    /**
     * метод возвращающий номер встречи
     * @return номер встречи
     */
    public String getId() {
        return id;
    }
}
