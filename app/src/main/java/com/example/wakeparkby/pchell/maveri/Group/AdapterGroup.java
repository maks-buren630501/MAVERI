package com.example.wakeparkby.pchell.maveri.Group;

public class AdapterGroup {
    Group group;
    public AdapterGroup(Group group) {
        this.group = group;
    }
    public String getGroupName() {
        return this.group.getName();
    }
    public String getGroupCoordinates() {
        return this.group.getCoordinates();
    }

    public String getGroupDate() {
        return this.group.getDate();
    }

    public String getGroupTime() {
        return this.group.getTime();
    }

    public String getGroupDescription() {
        return this.group.getDescription();
    }

    public String getGroupPassword() {
        return this.group.getPassword();
    }

    public String getGroupStatus() {
        return this.group.getStatus();
    }

    public String getGroupNumberOfUsers() {
        return this.group.getNumberOfUsers();
    }


}
