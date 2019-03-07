package com.example.wakeparkby.pchell.maveri.LocationSelection;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.wakeparkby.pchell.maveri.R;

public class ActivityLocationSelection extends AppCompatActivity implements View.OnClickListener {

    private Button continueButton;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selection);
        continueButton = (Button) findViewById(R.id.continueButton);
        continueButton.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Intent intent_DataSelection = new Intent(this,ActivityDateSelection.class);
        startActivity(intent_DataSelection);
    }
}
