package com.example.wakeparkby.pchell.maveri.Chat;

public class Message {
    public String text;
    public String date;
    public Boolean is_sent; // true // false

    public Message(String text, String data, Boolean is_sent) {
        this.text = text;
        this.date = data;
        this.is_sent = is_sent;
    }
}

