package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Profile.AdapterProfile;
import com.example.wakeparkby.pchell.maveri.R;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ActivityCreateProfile extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    ChangeToArray changeToArray=new ChangeToArray();
    ArrayList<String> interests = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView listMain;
    TextView selection;
    private Button countiusButton;
    private String interestString;
    private EditText editTextName;
    private EditText editTextSecond;
    private EditText editTextAge;

    private String firstName;
    private String lastName;
    private String age;
    private static String userKey;

    public static void setUserKey(String userKey) {
        ActivityCreateProfile.userKey = userKey;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        countiusButton = (Button) findViewById(R.id.countiusButton);
        countiusButton.setOnClickListener((View.OnClickListener) this);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSecond = (EditText) findViewById(R.id.editTextSecond);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

/*
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
*/
        getInterestMain();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,interests );
        listMain = findViewById(R.id.list1);
        listMain.setAdapter(adapter);


        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                SparseBooleanArray chosen = ((ListView) parent).getCheckedItemPositions();
                for (int i = 0; i < chosen.size(); i++) {
                    if (chosen.valueAt(i)) {
                        interestString+=changeToArray.GetStsring(0)[chosen.keyAt(i)]+", ";
                        System.out.print("");
                    }
                }
            }
        });

    }

  /*  private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new String(), "People");
        adapter.addFragment(new String(), "Group");
        adapter.addFragment(new String(), "Calls");
        viewPager.setAdapter(adapter);
    }*/



    private void getInterestMain(){

        for( int i = 0; i <= changeToArray.GetStsring(0).length - 1; i++) {
           // Interest interest = new Interest(changeToArray.GetStsring(0)[i]);
            interests.add(changeToArray.GetStsring(0)[i]);
       }


    }

    @Override
    public void onClick(View v) {
        firstName = String.valueOf(editTextName.getText());
        lastName = String.valueOf(editTextSecond.getText());
        age = String.valueOf(editTextAge.getText());
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.newProfile(userKey ,firstName,lastName,age,interestString);
        Toast.makeText(ActivityCreateProfile.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
        AdapterCreateProfile adapterCreateProfile = new AdapterCreateProfile();
        adapterCreateProfile.startActivitySignIn();
    }
}
