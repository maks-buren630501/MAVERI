package com.example.wakeparkby.pchell.maveri.Group;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.R;

public class ActivityCreateGroup extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Switch switch1;
    private TextView textViewNewPassword;
    private EditText editTextPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);
        switch1 = findViewById(R.id.switch1);
        if (switch1 != null) {
            switch1.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true){
            Toast.makeText(this, "ON",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "OFF",
                    Toast.LENGTH_SHORT).show();
            textViewNewPassword.setVisibility(View.VISIBLE);
            editTextPassword.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
