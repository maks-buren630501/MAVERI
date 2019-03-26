package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfile extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButtonBack;
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
        imageButtonBack = (ImageButton) findViewById(R.id.iButtonBackuserinfo);
        imageButtonBack.setOnClickListener(this);
        AdapterProfile adapterProfile = new AdapterProfile();
        profileName = adapterProfile.getProfileName();
        name.setText(profileName);
        listInterests = adapterProfile.getListInterests();
        interest.setText(listInterests);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iButtonBackuserinfo: {
                Intent intent = new Intent(this, ActivityMainMenu.class);
                startActivity(intent);
                break;
            }
        }
    }
}