package com.example.wakeparkby.pchell.maveri.Meeting;

import java.util.HashMap;

/**
 * класс для работы с встречей
 */
public class Meeting {

    private String id;
    private String coordinates;
    private String placeName;
    private String date;
    private String userName;

    /**
     * конструктор с параметрами
     * @param listMeetingChat спсок встреч из чата
     */
    public Meeting(HashMap<Integer, HashMap<String, String>> listMeetingChat) {

    }


    /**
     * конструктор с параметрами
     * @param coordinates координаты
     * @param placeName имя
     * @param date дата
     * @param userName номер встречи
     */
    public Meeting(String coordinates,String placeName,String date, String userName, String id){
        this.coordinates = coordinates;
        this.date = date;
        this.placeName = placeName;
        this.userName = userName;
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
    public String getPlaceName() {
        return placeName;
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
    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }
}
