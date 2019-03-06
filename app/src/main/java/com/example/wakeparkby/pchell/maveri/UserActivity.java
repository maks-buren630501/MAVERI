package com.example.wakeparkby.pchell.maveri;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButtonBack;
    TextView name;
    TextView interest;
    ArrayList<String> Spisok;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        name=findViewById(R.id.nameuserinfo);
        interest=findViewById(R.id.infintuserinfo);
        Spisok=new ArrayList<>();
        imageButtonBack=findViewById(R.id.iButtonBackuserinfo);
        imageButtonBack.setOnClickListener(this);

        Spisok.add("Хоккей");

        name.setText("Alex Rimash");
        interest.setText( Spisok.get(Spisok.size() - 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iButtonBackuserinfo:{
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}