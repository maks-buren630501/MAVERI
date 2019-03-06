package com.example.wakeparkby.pchell.maveri.Friend;

import java.util.ArrayList;

class Profile {
    private String name;
    private int photo;
    private int id;
    Profile(String string)
    {
        name=string;
    }

    public Profile() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
