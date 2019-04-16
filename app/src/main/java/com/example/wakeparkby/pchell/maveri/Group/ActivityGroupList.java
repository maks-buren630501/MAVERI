package com.example.wakeparkby.pchell.maveri.Group;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.wakeparkby.pchell.maveri.Chat.AdapterChat;
import com.example.wakeparkby.pchell.maveri.R;

public class ActivityGroupList extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton addNewGroup;
    ImageButton searchGroup;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        addNewGroup = findViewById(R.id.new_group_button);
        addNewGroup.setOnClickListener(this);
        searchGroup = findViewById(R.id.search_group_button);
        searchGroup.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_group_button: {
                GroupListController groupListController = new GroupListController();
                groupListController.startActivityCreateGroup(this);
                break;
            }

            case R.id.search_group_button: {
                AdapterChat.startActivityMap(this);
                break;
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
