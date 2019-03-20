package com.example.wakeparkby.pchell.maveri.Meeting;

import java.sql.Time;
import java.util.Date;

public class Meeting {

    private LatLng place;
    private String name;
    private Date date;
    private Time time;


    public Meeting(LatLng place, String name, Date date, Time time) {
        this.place = place;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }

    public Date getDate(){
        return this.date;
    }

    public Time getTime(){
        return this.time;
    }

    public LatLng getPlace() {
        return this.place;
    }
}
