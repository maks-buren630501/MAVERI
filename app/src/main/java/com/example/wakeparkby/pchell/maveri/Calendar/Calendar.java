package com.example.wakeparkby.pchell.maveri.Calendar;


import com.example.wakeparkby.pchell.maveri.Meeting.Meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class Calendar extends HashMap<Date, ArrayList<Meeting>> {
    public Set<Date> getAllMeetingDate() {
        return this.keySet();
    }

    public Calendar() {
        super();
    }

    public ArrayList<Meeting> get(Date date) {
        return super.get(date);
    }
}
