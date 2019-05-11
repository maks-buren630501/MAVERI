package com.example.wakeparkby.pchell.maveri;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;

import java.util.Vector;

/**
 * класс для обработки анимации
 */
public class AnimationLoad extends AppCompatActivity {
    private ImageView iMainPicture;
    private Animation aRotateEarth;
    ObserverMessage observer = new ObserverMessage("AnimationLoad") {

        /**
         * override method of Observer class with new reaction for notify observers

         */

        @Override
        public void update() {
            int n = observer.getStatus();

            if (n == 10) {

                if (observer.getId() == 3) {
                    startMainMenu();
                    observer.setId(0);
                } else {
                }
            }
        }


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        iMainPicture = findViewById(R.id.imageViewEarth);
        aRotateEarth = AnimationUtils.loadAnimation(this, R.anim.move_earth);
        iMainPicture.startAnimation(aRotateEarth);
    }

    private void startMainMenu() {
        Intent intent_MainMenu = new Intent(this, ActivityMainMenu.class);
        startActivity(intent_MainMenu);
    }

}
