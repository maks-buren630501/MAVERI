package com.example.wakeparkby.pchell.maveri.Chat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseMeeting;
import com.example.wakeparkby.pchell.maveri.Meeting.Meeting;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * класс для обработки интерфейса чата
 */
public class ActivityChat extends AppCompatActivity implements View.OnClickListener {
    AdapterChat adapterChat = Profile.getInstance().getAdapterChat();
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefMeessage;
    private ImageView sendButton;
    private ImageView selectPlaceButton;
    private EditText messageArea;
    private ListView listViewChat;
    private List<String> chatList;
    private HashMap<Integer, HashMap<String, String>> listMeetingChat;
    private String placeName;
    private String invateUserName;
    private String invateUserKey;
    private String date;
    private String coordinates;
    private final int IDD_THREE_BUTTONS = 0;
    private LatLng latLng = new LatLng(18.5259949, 109.3576236);

    ObserverMessage observer = new ObserverMessage("Chat") {

        /**
         * перегруженный метод обновления для частного экземпляра класса наблюдатель
         * в данном случае при обновлении обновляется либо основной чат, либо чат встреч
         */

        @Override
        public void update() {
            int n = observer.getStatus();

            if (n == 10) {

                if (observer.getId() == 1) {
                    refreshChat();
                    observer.setId(0);
                } else {
                }
                if (observer.getId() == 2) {
                    refreshChatMeeting();
                    observer.setId(0);
                } else {
                }
            }
        }


    };


    /**
     * метод создания объекта
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        listViewChat = findViewById(R.id.listViewChat);
        sendButton = findViewById(R.id.sendButton);
        messageArea = findViewById(R.id.messageArea);
        sendButton.setOnClickListener(this);
        // adapterChat.getListMessage(profile.getUserKey(),);
        //groupId = adapterChat.getGroupId();
        selectPlaceButton = findViewById(R.id.placeButton);
        selectPlaceButton.setOnClickListener(this);
        refreshChat();
    }


    /**
     * метод обновляющий чат
     */
    public void refreshChat() {
        chatList = Profile.getInstance().getAdapterChat().getListMessage().getMessages();
        ArrayAdapter<String> chatAdapter = new ArrayAdapter<>(ActivityChat.this,
                android.R.layout.simple_list_item_1,
                chatList.toArray(new String[chatList.size()]));
        listViewChat.setAdapter(chatAdapter);
        // chatList.clear();
    }

    /**
     * метод обновляющий чат встреч
     */
    public void refreshChatMeeting() {
        listMeetingChat = Profile.getInstance().getAdapterChat().getlistMeetingChat().getListMeetingChat();
        if (listMeetingChat.size() != 0) {
            for (Map.Entry entry : listMeetingChat.entrySet()) {
                int key = (int) entry.getKey();
                //values1.add((String[]) entry.getValue());
                this.invateUserKey = listMeetingChat.get(key).get("UserKey");
                this.placeName = listMeetingChat.get(key).get("PlaceName");
                this.date = listMeetingChat.get(key).get("Date");
                this.coordinates = listMeetingChat.get(key).get("LatLng");
                this.invateUserName = listMeetingChat.get(key).get("UserName");
                showDialog(IDD_THREE_BUTTONS);
            }
        }
    }

    /**
     * метод для обработки нажатия на кнопку
     * @param v сигнал нажатия
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sendButton: {
                String messageText = messageArea.getText().toString();
                adapterChat.sendMessage(messageText);
                messageArea.setText("");
                break;
            }

            case R.id.placeButton: {
                AdapterChat.startActivityMap(this);
                observer.removeFromList(observer);
                // showDialog(IDD_THREE_BUTTONS);

                break;
            }
        }
    }

    /**
     * метод для обработки пришедшего предложения о встрече
     * @param id код встречи
     * @return
     */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case IDD_THREE_BUTTONS:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(invateUserName + " предложил встречу");
                builder.setMessage("Дата: " + date + System.lineSeparator() + "Место: " + placeName)
                        .setCancelable(false)
                        .setPositiveButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                })
                        .setPositiveButton("Место на карте",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        startActivityMaps(coordinates);
                                    }
                                })
                        .setNeutralButton("Согласиться",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                        DatabaseMeeting databaseMeeting = new DatabaseMeeting();
                                        databaseMeeting.addNewMeetingUser(invateUserKey,invateUserName,coordinates,date,placeName);
                                        databaseMeeting.addNewMeetingInvateUser(invateUserKey,invateUserName,coordinates,date,placeName);
                                        databaseMeeting.removeMeetingChat(invateUserKey);
                                    }
                                });

                return builder.create();
            default:
                return null;
        }
    }

    /**
     * метод создающий окно выбора встреч
     * @param coordinates
     */
    private void startActivityMaps(String coordinates) {
        AdapterChat.startActivityMeetingOnMaps(this, coordinates);
    }


}
