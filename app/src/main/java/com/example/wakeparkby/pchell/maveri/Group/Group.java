package com.example.wakeparkby.pchell.maveri.Group;

public class Group {
    String status;
    String date;
    String time;
    String name;
    String description;
    String coordinates;
    String password;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getPassword() {
        return password;
    }

    public Group(String status, String date, String time, String name, String description, String coordinates, String password){
        this.coordinates = coordinates;
        this.date = date;
        this.time = time;
        this.name = name;
        this.description = description;
        this.coordinates = coordinates;
        this.password = password;
    }


}
