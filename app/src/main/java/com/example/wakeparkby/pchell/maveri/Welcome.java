package com.example.wakeparkby.pchell.maveri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wakeparkby.pchell.maveri.Friend.FriendListActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    public void on(View view) {
        Intent intent = new Intent(Welcome.this, FriendListActivity.class);
        startActivity(intent);
    }
}
