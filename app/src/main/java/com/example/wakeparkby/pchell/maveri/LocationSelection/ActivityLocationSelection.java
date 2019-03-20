package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wakeparkby.pchell.maveri.Meeting.AdapterListMeeting;
import com.example.wakeparkby.pchell.maveri.Meeting.ListMeeting;
import com.example.wakeparkby.pchell.maveri.R;

import java.sql.Time;
import java.util.Date;

public class ActivityLocationSelection extends AppCompatActivity implements View.OnClickListener {

    private Button continueButton;

    private AdapterListMeeting adapterListMeeting = new AdapterListMeeting();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        AdapterLocationSelection.startActivityDateSelection(this);
    }

    public LatLng getPlaces() {

    }

    public String getName() {

    }

    public Date getDate() {

    }

    public Time getTime() {

    }


}
