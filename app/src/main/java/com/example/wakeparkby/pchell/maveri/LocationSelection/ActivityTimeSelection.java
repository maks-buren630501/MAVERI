package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.example.wakeparkby.pchell.maveri.Chat.ActivityChat;
import com.example.wakeparkby.pchell.maveri.R;

/**
 * класс для работы с объектом интерфейса для выбора времени
 */
public class ActivityTimeSelection extends AppCompatActivity implements View.OnClickListener {

    Button continueButton;
    TimePicker timePicker;
    private String time;

    /**
     * стандартный android метод создания
     * @param savedInstanceState стандартный android параметр
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_selection);
        continueButton = (Button) findViewById(R.id.buttonSelectTime);
        continueButton.setOnClickListener((View.OnClickListener) this);
        timePicker = findViewById(R.id.timePicker);
    }
    /**
     * метод для обработки нажатий
     * @param v статус нажатия
     */
    @Override
    public void onClick(View v) {
            time = String.valueOf(timePicker.getCurrentHour() +":" + timePicker.getCurrentMinute());
        Intent intent_Chat = new Intent(this,ActivityChat.class);
        AdapterMapsDataTime adapterMapsDataTime = new AdapterMapsDataTime(getIntent().getStringExtra("coordinates"),
                getIntent().getStringExtra("date"), time , getIntent().getStringExtra("name"));
        AdapterMapsDataTime.startActivity(this,intent_Chat);
    }
}
