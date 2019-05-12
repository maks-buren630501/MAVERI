package com.example.wakeparkby.pchell.maveri.Chat;

import java.util.Date;

public class Message {

    public String message;
    public String date;
    public String userName;
    public Boolean is_sent; // true // false

    public Message(String userName, String message, String messageDate, Boolean is_sent) {
        this.userName = userName;
        this.message = message;
        this.date = messageDate;
        this.is_sent = is_sent;
    }
}

