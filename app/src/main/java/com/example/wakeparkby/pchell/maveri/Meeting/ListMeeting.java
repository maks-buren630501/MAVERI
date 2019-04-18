package com.example.wakeparkby.pchell.maveri.Meeting;

import java.util.ArrayList;

/**
 * класс для хранения и обработки списка встреч
 */
public class ListMeeting {

    private ArrayList<Meeting> meetings = new ArrayList<>();

    /**
     * метод добавляющий встречу
     * @param meeting встреча
     */
    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    /**
     * метод для получения встречи по номеру в списке
     * @param index номер с списке
     * @return встреча по номеру
     */
    public Meeting getMeetingByIndex(int index) {
        return meetings.get(index);
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
