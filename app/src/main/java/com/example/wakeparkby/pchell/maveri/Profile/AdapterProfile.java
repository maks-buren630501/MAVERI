package com.example.wakeparkby.pchell.maveri.Profile;

public class AdapterProfile {


    private static String profileName;
    private static String listInterests;
    Profile profile = new Profile();

    public String getProfileName() {
        return profileName;
    }

    public String getListInterests() {
        return listInterests;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public void setListInterests(String listInterests) {
        this.listInterests = listInterests;
    }

    /*public void setUserInfo() {
        ActivityProfile activityProfile = new ActivityProfile();
        activityProfile.setUserInfo();
    }*/
}
