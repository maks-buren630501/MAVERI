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

    private Button continueButton;
    private DatePicker datePicker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);
        continueButton = (Button) findViewById(R.id.buttonSelectDate);
        continueButton.setOnClickListener((View.OnClickListener) this);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        Calendar cal=Calendar.getInstance();
        long now = System.currentTimeMillis() - 1000;
        datePicker.setMinDate(now);
        datePicker.setMaxDate(now+(1000*60*60*24*13));
    }

    @Override
    public void onClick(View v) {
        AdapterDateSelection adapterDateSelection = new AdapterDateSelection();
        adapterDateSelection.startActivityTimeSelection();
    }
}
