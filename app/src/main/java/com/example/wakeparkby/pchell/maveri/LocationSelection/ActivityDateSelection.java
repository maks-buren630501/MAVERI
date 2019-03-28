package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.wakeparkby.pchell.maveri.R;

import java.util.Calendar;

public class ActivityDateSelection extends AppCompatActivity implements View.OnClickListener {

    Button continueButton;
    DatePicker datePicker;
    private String date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);
        continueButton = (Button) findViewById(R.id.buttonSelectDate);
        continueButton.setOnClickListener((View.OnClickListener) this);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        long now = System.currentTimeMillis() - 1000;
        datePicker.setMinDate(now);
        datePicker.setMaxDate(now + (1000 * 60 * 60 * 24 * 13));
    }

    @Override
    public void onClick(View v) {
        String mMonth;
        if (datePicker.getMonth() + 1 < 10) {
            mMonth = "0" + String.valueOf(datePicker.getMonth());
        } else {
            mMonth = String.valueOf(datePicker.getMonth());
        }
        date = datePicker.getDayOfMonth() + "." + mMonth + "." + datePicker.getYear();

        int mYear = datePicker.getYear();
        Intent intent_Time = new Intent(this, ActivityTimeSelection.class);
        intent_Time.putExtra("coordinates", getIntent().getStringExtra("coordinates"));
        intent_Time.putExtra("name",getIntent().getStringExtra("name"));
        intent_Time.putExtra("date",date);
        AdapterMapsDataTime.startActivity(this, intent_Time);
    }
}
