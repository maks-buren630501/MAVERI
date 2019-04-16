package com.example.wakeparkby.pchell.maveri.Profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.R;

import java.util.ArrayList;

public class ActivityProfile extends AppCompatActivity implements View.OnClickListener {

    private TextView name;
    private TextView interest;
    ImageView image;
    Button change;
    private String profileName;
    private String listInterests;
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        image = findViewById(R.id.iv_profileuserinfo);
        change = findViewById(R.id.changeuserinfo);
        change.setOnClickListener(this);
        name = (TextView) findViewById(R.id.nameuserinfo);
        interest = (TextView) findViewById(R.id.infintuserinfo);
        AdapterProfile adapterProfile = new AdapterProfile();
        profileName = adapterProfile.getProfileName();
        name.setText(profileName);
        listInterests = adapterProfile.getListInterests();
        interest.setText(listInterests);
        TabHost tabHostuser = (TabHost) findViewById(R.id.UserInformation);

        tabHostuser.setup();

        TabHost.TabSpec tabSpecuser = tabHostuser.newTabSpec("tag1user");

        tabSpecuser.setContent(R.id.tab1userinfo);
        tabSpecuser.setIndicator("Баланс");
        tabHostuser.addTab(tabSpecuser);

        tabSpecuser = tabHostuser.newTabSpec("tag2user");
        tabSpecuser.setContent(R.id.tab2userinfo);
        tabSpecuser.setIndicator("О себе");
        tabHostuser.addTab(tabSpecuser);

        tabSpecuser = tabHostuser.newTabSpec("tag3user");
        tabSpecuser.setContent(R.id.tab3userinfo);
        tabSpecuser.setIndicator("Встречи");
        tabHostuser.addTab(tabSpecuser);

        tabHostuser.setCurrentTab(0);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.changeuserinfo: {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        }
        }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE) {
            Uri fullPhotoUri = data.getData();
            image.setImageURI(fullPhotoUri);
        }
    }
}