package com.example.wakeparkby.pchell.maveri.Meeting;

import com.example.wakeparkby.pchell.maveri.LocationSelection.ActivityLocationSelection;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.Date;

public class AdapterListMeeting {

    Profile profile;
    private ListMeeting listMeeting;

    public AdapterListMeeting(){
        profile = Profile.getInstance();
        listMeeting = profile.getListMeeting();
    }

    public void addMeeting(LatLng place, String name, Date date, Time time){
        listMeeting.addMeeting(new Meeting(place,name,date,time));
    }

    public void removeMeeting(int index){
        listMeeting.removeMeeting(index);
    }






}
