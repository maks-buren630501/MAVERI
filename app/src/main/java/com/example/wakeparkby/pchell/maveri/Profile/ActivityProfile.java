package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfile extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView interest;

    private String profileName;
    private String listInterests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        name = (TextView) findViewById(R.id.nameuserinfo);
        interest = (TextView) findViewById(R.id.infintuserinfo);
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
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}