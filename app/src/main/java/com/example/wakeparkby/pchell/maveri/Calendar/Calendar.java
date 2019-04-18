package com.example.wakeparkby.pchell.maveri.Calendar;


import com.example.wakeparkby.pchell.maveri.Meeting.Meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/**
 * класс для работы с календарем
 * наследован от HashMap
 */
public class Calendar extends HashMap<Date, ArrayList<Meeting>> {
    public Set<Date> getAllMeetingDate() {
        return this.keySet();
    }

    /**
     * базовый конструктор
     */
    public Calendar() {
        super();
    }

    /**
     * метод для получения встреч за орпеделенный день
     * @param date день за который нужно получить встречи
     * @return список встреч за данный день
     */
    public ArrayList<Meeting> get(Date date) {
        return super.get(date);
    }
}
