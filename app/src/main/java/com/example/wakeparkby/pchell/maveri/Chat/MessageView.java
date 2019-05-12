package com.example.wakeparkby.pchell.maveri.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.R;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MessageView extends RecyclerView.ViewHolder {
    TextView messageText;
    TextView messageTime;


    public MessageView(View itemView) {
        super(itemView);
        messageText = itemView.findViewById(R.id.messageText);
        messageTime = itemView.findViewById(R.id.messageTime);



    }
    ProfileFriend pro = new ProfileFriend();
    public void bind(Message message) {
        messageText.setText(message.text);
        messageTime.setText(message.date);
    }
}

