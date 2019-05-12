package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * класс для интерфейса создания аккаунта
 */
public class ActivityCreateAccount extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference("Users");
    private FirebaseAuth mAuth;
    private EditText etEmail;
    private EditText etPassword;

    @Override
    /**
     * базовый android метод для старта объекта интерфейса
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.editTextGroupName);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        findViewById(R.id.buttonEnterNew).setOnClickListener(this);

    }

    /**
     * метод для обработки нажатия
     * @param view состояние нажатия
     */
    @Override
    public void onClick(View view) {
        if (etEmail.getText().toString().equals("")) {
            Toast.makeText(ActivityCreateAccount.this, "Введите Email !!!", Toast.LENGTH_SHORT).show();
        } else if (etPassword.getText().toString().equals("")) {
            Toast.makeText(ActivityCreateAccount.this, "Введите Password !!!", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.buttonEnterNew) {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            registration(email, password);
        }
    }

    /**
     * егистрация в базе данных нового пользователя
     * @param email почта
     * @param password парроль
     */

    public void registration(final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            //-----Отправка сообщения на Gmail о регистрации
                            mAuth.getCurrentUser().sendEmailVerification();
                            String userKey = mAuth.getCurrentUser().getUid();
                            ActivityCreateProfile activityCreateProfile = new ActivityCreateProfile();
                            activityCreateProfile.setUserKey(userKey);
                            startActivityCreateProfile();
                        } else {
                            Toast.makeText(ActivityCreateAccount.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                        }


                        // ...

                    }

                });
    }

    /**
     * метод для старта создания профиля
     */
    private void startActivityCreateProfile() {
        AdapterCreateAccount.startActivityCreateProfile(this);
    }
}

