package com.example.wakeparkby.pchell.maveri.Friend;

class Profile {
    private String name;
    private String photo;
    Profile(String string)
    {
        name=string;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
