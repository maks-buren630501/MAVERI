package com.example.wakeparkby.pchell.maveri.Meeting;

import java.util.ArrayList;

public class ListMeeting {

    private ArrayList<Meeting> meetings = new ArrayList<>();

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public Meeting getMeetingByIndex(int index) {
        return meetings.get(index);
    }

    public int getSize() {
        return meetings.size();
    }

    public void removeMeeting(int index) {
        this.meetings.remove(index);
    }

}
