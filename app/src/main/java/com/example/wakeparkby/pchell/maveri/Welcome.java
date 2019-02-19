package com.example.wakeparkby.pchell.maveri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity implements View.OnClickListener {
        private Button buttonRealtimeDB;
        private Button buttonCloudDB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_welcome);
                buttonRealtimeDB = (Button) findViewById(R.id.buttonReal);
                buttonRealtimeDB.setOnClickListener((View.OnClickListener) this);
                buttonCloudDB = (Button) findViewById(R.id.buttonCloud);
                buttonCloudDB.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View v) {
                Intent intent_RealtimeChat = new Intent(this, RealtimeChat.class);
                Intent intent_CloudChat = new Intent(this, CloudChat.class);
                switch (v.getId()) {
                        case R.id.buttonReal:
                                startActivity(intent_RealtimeChat);
                                break;
                        case R.id.buttonCloud:
                                startActivity(intent_CloudChat);
                                break;
                }


        }
}
