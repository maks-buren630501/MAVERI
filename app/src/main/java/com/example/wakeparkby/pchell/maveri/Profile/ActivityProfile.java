package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.Bluetooth.ActivityMainBluetooth;
import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.Meeting.Meeting;
import com.example.wakeparkby.pchell.maveri.ObserverMessage;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;
import java.util.List;

/**
 * класс для работы с объектом интерфейса профиля
 */
public class ActivityProfile extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    TextView name;
    TextView interest;
    ListView infmeetuserinfo;
    private String profileName;
    private String listInterests;
    private List <String> meetingList = new ArrayList<>();
    ImageView image;
    Button change;
    public static final int PICK_IMAGE = 1;
    ObserverMessage observer = new ObserverMessage("Profile") {

        /**
         * перегруженный метод обновления для частного экземпляра класса наблюдатель
         * в данном случае при обновлении обновляется либо основной чат, либо чат встреч
         */

        @Override
        public void update() {
            int n = observer.getStatus();
            if (n == 10) {
                if (observer.getId() == 5) {
                    updateMeeting();
                    observer.setId(0);
                }
            }
        }


    };



    /**
     * стандартный метод создания android
     *
     * @param savedInstanceState стандартный параметр
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        image = findViewById(R.id.iv_profileuserinfo);
        change = findViewById(R.id.changeuserinfo);
        change.setOnClickListener(this);
        name = (TextView) findViewById(R.id.nameuserinfo);
        interest = (TextView) findViewById(R.id.infintuserinfo);
        infmeetuserinfo = findViewById(R.id.infmeetuserinfo);
        infmeetuserinfo.setOnItemClickListener(this);
        AdapterProfile adapterProfile = new AdapterProfile();
        profileName = adapterProfile.getProfileName();
        name.setText(profileName);
        listInterests = adapterProfile.getListInterests();
        interest.setText(listInterests);
        TabHost tabHostuser = (TabHost) findViewById(R.id.UserInformation);
        tabHostuser.setup();
        TabHost.TabSpec tabSpecuser = tabHostuser.newTabSpec("tag1user");
        tabSpecuser.setContent(R.id.tab1userinfo);
        tabSpecuser.setIndicator("Баланс");
        tabHostuser.addTab(tabSpecuser);
        tabSpecuser = tabHostuser.newTabSpec("tag2user");
        tabSpecuser.setContent(R.id.tab2userinfo);
        tabSpecuser.setIndicator("О себе");
        tabHostuser.addTab(tabSpecuser);
        tabSpecuser = tabHostuser.newTabSpec("tag3user");
        tabSpecuser.setContent(R.id.tab3userinfo);
        tabSpecuser.setIndicator("Встречи");
        tabHostuser.addTab(tabSpecuser);
        tabHostuser.setCurrentTab(0);
        meetingList.add("ТЕСТ");
        ArrayAdapter<String> profileMeetingAdapter = new ArrayAdapter<>(ActivityProfile.this,
                android.R.layout.simple_list_item_1,
                meetingList.toArray(new String[meetingList.size()]));
        infmeetuserinfo.setAdapter(profileMeetingAdapter);
    //    updateMeeting();
    }

    /**
     * метод для обработки нажатий
     *
     * @param v статус нажатия
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changeuserinfo: {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");
                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            Uri fullPhotoUri = data.getData();
            image.setImageURI(fullPhotoUri);
        }
    }


    private void updateMeeting() {
        meetingList.clear();
        for ( int i = 0 ; i < Profile.getInstance().getListMeeting().getMeetings().size(); i++)
        {
            String name = String.valueOf(Profile.getInstance().getListMeeting().getMeetings().get(i).getUserName());
            String date = String.valueOf(Profile.getInstance().getListMeeting().getMeetings().get(i).getDate());
            meetingList.add(name + " " + date);
        }
        ArrayAdapter<String> profileMeetingAdapter = new ArrayAdapter<>(ActivityProfile.this,
                android.R.layout.simple_list_item_1,
                meetingList.toArray(new String[meetingList.size()]));
                infmeetuserinfo.setAdapter(profileMeetingAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        String infoMeetingAtPosition = (String) adapterView.getItemAtPosition(position);
        Intent intent_MainBluetooth = new Intent(this, ActivityMainBluetooth.class);
        AdapterProfile.startActivity(this,intent_MainBluetooth);
    }
}