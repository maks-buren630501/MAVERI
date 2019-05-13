package com.example.wakeparkby.pchell.maveri.Friend.ReqestFriend;
        import java.util.ArrayList;

public class ListReqestUser {
    ArrayList<ReqestFriend> reqestFriends = new ArrayList<>();

    public ArrayList<ReqestFriend> getReqest() {
        return reqestFriends;
    }

    public void setReqest(ArrayList<ReqestFriend> groups) {
        this.reqestFriends = groups;
    }

    public ReqestFriend getReqest(int index){
        return reqestFriends.get(index);
    }

    public void addReqest(ReqestFriend group){
        reqestFriends.add(group);
    }
}
