package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.support.design.widget.FloatingActionButton;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.example.wakeparkby.pchell.maveri.Onboarding.OnboardingActivity;
import com.example.wakeparkby.pchell.maveri.R;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * класс для интерфейса создания профиля
 */
public class ActivityCreateProfile extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    AllDataProfile changeToArray=new AllDataProfile();
    ArrayList<String> lowInterests = new ArrayList<String>();
    ArrayList<String> highInterests = new ArrayList<String>();
    ArrayAdapter adapter;

    ListView listMain;
    private FloatingActionButton countiusButton;
    private String interestString;
    private EditText editTextName;
    private EditText editTextSecond;
    private EditText editTextAge;

    private String firstName;
    private String lastName;
    private String age;
    private static String userKey;

    /**
     * метод для установки номера пользователя
     * @param userKey номер пользователя
     */
    public static void setUserKey(String userKey) {
        ActivityCreateProfile.userKey = userKey;
    }

    /**
     * базовый android метод для старта объекта интерфейса
     * @param savedInstanceState базовый параметр
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_profile);

        countiusButton = (FloatingActionButton) findViewById(R.id.countiusButton);
        countiusButton.setOnClickListener(this);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextSecond = (EditText) findViewById(R.id.editTextSecond);
        editTextAge = (EditText) findViewById(R.id.editTextAge);

        getInterestLowInterests(0);
        getInterestHighInterests();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,highInterests );
        listMain = findViewById(R.id.list1);
        listMain.setAdapter(adapter);


        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AllDataProfile.positionLowList = position;
                Intent intent = new Intent(ActivityCreateProfile.this, ActivityChooseLowInterests.class);
                startActivity(intent);
            }
        });

    }

    /**
     * получение списка интересов
     */
    private void getInterestHighInterests(){
            highInterests=changeToArray.GetStringHighInterests();
    }

    /**
     * получение интереса по его позиции в списке
     * @param position позиция в списке
     */
    private void getInterestLowInterests(int position) {
        for (int i = 0; i <= changeToArray.GetStringLowInterests(position).length - 1; i++) {
            lowInterests.add(changeToArray.GetStringLowInterests(position)[i]);
        }
    }

    /**
     * метод для обработки нажатия в списке
     * @param v состяние нажатия
     */
    @Override
    public void onClick(View v) {
        firstName = String.valueOf(editTextName.getText());
        lastName = String.valueOf(editTextSecond.getText());
        age = String.valueOf(editTextAge.getText());
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.newProfile(userKey ,firstName,lastName,age,interestString);
        Toast.makeText(ActivityCreateProfile.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
        Intent intent_onboarding = new Intent(this, OnboardingActivity.class);
        startActivity(intent_onboarding);
    }
}
