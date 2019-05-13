package com.example.wakeparkby.pchell.maveri.Friend.ReqestFriend;

public class ReqestFriend {
    String name;
    String lastName;
    String reqestUserKey;
    public ReqestFriend(String reqestUserKey, String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.reqestUserKey = reqestUserKey;
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

    public String getReqestUserKey() {
        return reqestUserKey;
    }

    public void setReqestUserKey(String reqestUserKey) {
        this.reqestUserKey = reqestUserKey;
    }
}


