package com.example.wakeparkby.pchell.maveri.Group;

import java.util.ArrayList;

public class ListGroups {
    ArrayList<Group> groups = new ArrayList<>();

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public Group getGroup(int index){
       return groups.get(index);
    }

    public void addGroup(Group group){
        groups.add(group);
    }
}
