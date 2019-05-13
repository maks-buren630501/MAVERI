package com.example.wakeparkby.pchell.maveri.Friend.RequestFriend;

public class RequestFriend {
    String name;
    String lastName;
    String requestUserKey;
    public RequestFriend(String reqestUserKey, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.requestUserKey = reqestUserKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRequestUserKey() {
        return requestUserKey;
    }

    public void setRequestUserKey(String requestUserKey) {
        this.requestUserKey = requestUserKey;
    }
}


