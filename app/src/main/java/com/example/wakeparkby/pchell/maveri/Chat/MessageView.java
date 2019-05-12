package com.example.wakeparkby.pchell.maveri.Chat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MessageView extends RecyclerView.ViewHolder {
    TextView messageText;
    TextView messageTime;
    TextView messageUserName;


    public MessageView(View itemView) {
        super(itemView);
        messageText = itemView.findViewById(R.id.messageText);
        messageTime = itemView.findViewById(R.id.messageTime);
        messageUserName = itemView.findViewById(R.id.textViewMessageUserName);
    }

    public void bind(Message message) {
        messageText.setText(message.message);
        messageTime.setText(message.date);
        messageUserName.setText(message.userName);
    }
}
