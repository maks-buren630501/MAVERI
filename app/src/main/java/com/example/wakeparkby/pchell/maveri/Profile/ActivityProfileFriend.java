package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfileFriend extends AppCompatActivity implements View.OnClickListener{


    ImageButton imageButtonBack;
    TextView name;
    TextView interest;
    ArrayList<String> Spisok;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        name=findViewById(R.id.namefriendinfo);
        interest=findViewById(R.id.infintfriendinfo);
        Spisok=new ArrayList<>();
        imageButtonBack=findViewById(R.id.iButtonBackfriendinfo);
        imageButtonBack.setOnClickListener(this);

        Spisok.add("Хоккей");

        name.setText("Alex Rimash");
        interest.setText( Spisok.get(Spisok.size() - 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iButtonBackfriendinfo:{
                Intent intent = new Intent(this, ActivityMainMenu.class);
                startActivity(intent);
                break;
            }
        }
    }
}
