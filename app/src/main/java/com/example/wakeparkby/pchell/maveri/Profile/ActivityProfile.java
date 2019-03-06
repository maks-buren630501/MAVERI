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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        //AdapterProfile adapterProfile = new AdapterProfile();
        //adapterProfile.getUserInfo();

        name= (TextView) findViewById(R.id.nameuserinfo);
        interest= (TextView) findViewById(R.id.infintuserinfo);
        imageButtonBack=(ImageButton) findViewById(R.id.iButtonBackuserinfo);
        imageButtonBack.setOnClickListener(this);
       // String returnName = adapterProfile.getFirstName() + " " + adapterProfile.getLastName();
       // name.setText(returnName);
        //interest.setText(adapterProfile.getInterests());

       // ( Spisok.get(Spisok.size() - 1));
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iButtonBackuserinfo:{
                Intent intent = new Intent(this, ActivityMainMenu.class);
                startActivity(intent);
                break;
            }
        }
    }
}