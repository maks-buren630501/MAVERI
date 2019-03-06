package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wakeparkby.pchell.maveri.R;

public class ActivityDateSelection extends AppCompatActivity implements View.OnClickListener {

    private Button continueButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_selection);
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_TimeSelection = new Intent (this,ActivityTimeSelection.class);
        startActivity(intent_TimeSelection);
    }
}
