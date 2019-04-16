package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import com.example.wakeparkby.pchell.maveri.R;

import java.sql.Time;

public class ActivityCreateDateAndTimeGroup extends AppCompatActivity implements View.OnClickListener {
    private Button buttonEnterGroup;
    private DatePicker datePicker;
    private TimePicker timePicker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_date_and_time_group);
        buttonEnterGroup = findViewById(R.id.buttonEnterCreateDateAndTimeGroup);
        buttonEnterGroup.setOnClickListener(this);
        datePicker = findViewById(R.id.datePickerCreateGroup);
        timePicker = findViewById(R.id.timePickerCreateGroup);
        datePicker.setMinDate(System.currentTimeMillis() - 1000);
        datePicker.setMaxDate(System.currentTimeMillis() - 1000 + (1000 * 60 * 60 * 24 * 13));
    }

    @Override
    public void onClick(View v) {
        String mMonth;
        if (datePicker.getMonth() + 1 < 10) {
            mMonth = "0" + String.valueOf(datePicker.getMonth());
        } else {
            mMonth = String.valueOf(datePicker.getMonth());
        }
        String date = datePicker.getDayOfMonth() + "." + mMonth + "." + datePicker.getYear();
        String time = String.valueOf(timePicker.getCurrentHour() +":" + timePicker.getCurrentMinute());
        Intent intent_createSelectPlace = new Intent(this,ActivityCreateSelectPlaceGroup.class);
        intent_createSelectPlace.putExtra("Name",getIntent().getStringExtra("Name"));
        intent_createSelectPlace.putExtra("Description",getIntent().getStringExtra("Description"));
        intent_createSelectPlace.putExtra("Status",String.valueOf(getIntent().getIntExtra("Status",0)));
        intent_createSelectPlace.putExtra("Date",date);
        intent_createSelectPlace.putExtra("Time",time);
        if (getIntent().getIntExtra("Status",0) !=0)
        {
            intent_createSelectPlace.putExtra("Password", getIntent().getStringExtra("Password"));
        }
        CreateGroupController.startActivity(this,intent_createSelectPlace);
    }
}
