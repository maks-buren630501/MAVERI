package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;

public class ActivityCreateInfoGroup extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Switch switch1;
    private TextView textViewNewPassword;
    private EditText editTextPassword;
    private Button buttonEnterCreateGroup;
    private EditText editTextGroupName;
    private EditText editTextDescription;
    private int fl = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_info_group);
        switch1 = findViewById(R.id.switch1);
        if (switch1 != null) {
            switch1.setOnCheckedChangeListener(this);
        }
        textViewNewPassword = findViewById(R.id.textViewNewPasswordCreateGroup);
        editTextPassword = findViewById(R.id.editTextPasswordCreateGroup);
        editTextGroupName = findViewById(R.id.editTextGroupName);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonEnterCreateGroup = findViewById(R.id.buttonEnterCreateGroup);
        buttonEnterCreateGroup.setOnClickListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked == true) {
            textViewNewPassword.setVisibility(View.VISIBLE);
            editTextPassword.setVisibility(View.VISIBLE);
            fl = 1;
        } else {
            textViewNewPassword.setVisibility(View.GONE);
            editTextPassword.setVisibility(View.GONE);
            editTextPassword.setText("");
            fl = 0;
        }
    }


    @Override
    public void onClick(View v) {
        if (editTextGroupName.getText().toString().equals("")) {
            Toast.makeText(this, "Введите название группы !!!", Toast.LENGTH_SHORT).show();
        } else if (editTextDescription.getText().toString().equals("")) {
            Toast.makeText(this, "Введите описание !!!", Toast.LENGTH_SHORT).show();
        } else if(fl == 1){
             if (editTextPassword.getText().toString().equals("")) {
                Toast.makeText(this, "Введите пароль !!!", Toast.LENGTH_SHORT).show();
            } else
             {
                 Intent intent_CreateDateAndTimeGroup = new Intent(this,ActivityCreateDateAndTimeGroup.class);
                 intent_CreateDateAndTimeGroup.putExtra("Name",String.valueOf(editTextGroupName.getText()));
                 intent_CreateDateAndTimeGroup.putExtra("Description",String.valueOf(editTextDescription.getText()));
                 intent_CreateDateAndTimeGroup.putExtra("Password",String.valueOf(editTextPassword.getText()));
                 intent_CreateDateAndTimeGroup.putExtra("Status",fl);
                 CreateGroupController.startActivity(this,intent_CreateDateAndTimeGroup);
             }
        } else if (v.getId() == R.id.buttonEnterCreateGroup) {
            Intent intent_CreateDateAndTimeGroup = new Intent(this,ActivityCreateDateAndTimeGroup.class);
            intent_CreateDateAndTimeGroup.putExtra("Name",String.valueOf(editTextGroupName.getText()));
            intent_CreateDateAndTimeGroup.putExtra("Description",String.valueOf(editTextDescription.getText()));
            intent_CreateDateAndTimeGroup.putExtra("Status",fl);
            CreateGroupController.startActivity(this,intent_CreateDateAndTimeGroup);
        }



    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}


