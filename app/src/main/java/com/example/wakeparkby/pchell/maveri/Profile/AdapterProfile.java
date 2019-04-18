package com.example.wakeparkby.pchell.maveri.Profile;

/**
 * класс для связи интерфейса и логики пользователя
 */
public class AdapterProfile {
    Profile profile = Profile.getInstance();

    /**
     * метод возврощающий имя пользователя
     * @return имя пользователя
     */
    public String getProfileName() {
        return profile.getFirstName() + " " + profile.getLastName();
    }

    /**
     * метод возврощающий список интересов пользователся
     * @return список интересов пользователся
     */
    public String getListInterests() {
        return profile.getListInterests();

    }
}
