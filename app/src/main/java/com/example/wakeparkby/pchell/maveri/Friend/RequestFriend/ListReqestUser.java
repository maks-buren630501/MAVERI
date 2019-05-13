package com.example.wakeparkby.pchell.maveri.Friend.RequestFriend;
        import java.util.ArrayList;

public class ListReqestUser {
    ArrayList<RequestFriend> requestFriends = new ArrayList<>();

    public ArrayList<RequestFriend> getReqest() {
        return requestFriends;
    }

    public void setReqest(ArrayList<RequestFriend> groups) {
        this.requestFriends = groups;
    }

    public RequestFriend getReqest(int index){
        return requestFriends.get(index);
    }

    public void addReqest(RequestFriend group){
        requestFriends.add(group);
    }
}
