package com.example.wakeparkby.pchell.maveri.MainMenu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.wakeparkby.pchell.maveri.Friend.ActivityFriendList;
import com.example.wakeparkby.pchell.maveri.Profile.ActivityProfile;
import com.example.wakeparkby.pchell.maveri.Profile.CircularImageView;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.R;

import org.w3c.dom.Text;

/**
 * класс для работы с объектом интерфейса главного меню
 */
public class ActivityMainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private TextView textViewNameProfile;


    /**
     * стандартный android метод создания
     * @param savedInstanceState стандартный android параметр
     */
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_main);
        CircularImageView headerButtonView = headerLayout.findViewById(R.id.profile);
        headerButtonView.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        textViewNameProfile = headerLayout.findViewById(R.id.TextViewNameProfile);
        textViewNameProfile.setText(Profile.getInstance().getFirstName() + " " + Profile.getInstance().getLastName());
    }

    /**
     * метод для обработки нажатия клавиши назад
     */
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * метод для получения статуса создания доп меню
     * @param menu меню
     * @return статут
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * метод для получения статуса
     * @param item
     * @return статус
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * метод для получения статуса
     * @param item
     * @return статус
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.friends) {
            AdapterMainMenu.startActivityFriendList(this);
        } else if (id == R.id.calendar) {
            //AdapterMainMenu.startActivityMaps(this);
        } else if (id == R.id.message) {


        } else if (id == R.id.settings) {
            System.out.println("GOGOGO");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * метод для обработки нажатий
     * @param v статус нажатия
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile: {
                AdapterMainMenu.startActivityProfile(this);
                break;
            }
        }
    }
}
