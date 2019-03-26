package com.example.wakeparkby.pchell.maveri.Profile;

public class AdapterProfile {
    Profile profile = Profile.getInstance();

    public String getProfileName() {
        return profile.getFirstName() + " " + profile.getLastName();
    }

    public String getListInterests() {
        return profile.getListInterests();

    }
}
