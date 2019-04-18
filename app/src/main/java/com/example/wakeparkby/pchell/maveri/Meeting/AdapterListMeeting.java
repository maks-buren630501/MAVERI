package com.example.wakeparkby.pchell.maveri.Meeting;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.google.android.gms.maps.model.LatLng;

import java.sql.Time;
import java.util.Date;

/**
 * класс для работы со списком встреч
 */
public class AdapterListMeeting {

    Profile profile;
    private ListMeeting listMeeting;

    /**
     * конструктор по умолчанию. Получает данные из профиля
     */
    public AdapterListMeeting() {
        profile = Profile.getInstance();
        listMeeting = profile.getListMeeting();
    }

    /**
     * метод для удаления встречи из списка
     * @param index
     */
    public void removeMeeting(int index) {
        listMeeting.removeMeeting(index);
    }


}
