package com.example.wakeparkby.pchell.maveri.Group;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.R;

public class ActivityGroup extends AppCompatActivity implements View.OnClickListener {
    TextView dateText;
    TextView timeText;
    TextView manyPeople;
    TextView description;
    Button map_button_sticky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_profile);
        dateText = findViewById(R.id.date_text);
        timeText = findViewById(R.id.time_text);
        description = findViewById(R.id.afisha__text);
        manyPeople = findViewById(R.id.how_many_people__text);
        map_button_sticky = findViewById(R.id.map_button_sticky);
        map_button_sticky.setOnClickListener(this);
        dateText.setText(getIntent().getStringExtra("groupDate"));
        timeText.setText(getIntent().getStringExtra("groupTime"));
        description.setText(getIntent().getStringExtra("groupDescription"));
        manyPeople.setText(getIntent().getStringExtra("numberOfUsers"));
    }

    @Override
    public void onClick(View v) {

    }
}
