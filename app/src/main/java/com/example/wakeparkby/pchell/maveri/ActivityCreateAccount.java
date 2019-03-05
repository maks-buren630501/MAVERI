package com.example.wakeparkby.pchell.maveri;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.Future;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityCreateAccount extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference("Users");
    private FirebaseAuth mAuth;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mAuth = FirebaseAuth.getInstance();
        etEmail = (EditText) findViewById(R.id.editTextEmail);
        etPassword = (EditText) findViewById(R.id.editTextPassword);
        etUserName = (EditText) findViewById(R.id.editTextName);
        findViewById(R.id.buttonSave).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (etEmail.getText().toString().equals("")) {
            Toast.makeText(ActivityCreateAccount.this, "Введите Email !!!", Toast.LENGTH_SHORT).show();
        } else if (etPassword.getText().toString().equals("")) {
            Toast.makeText(ActivityCreateAccount.this, "Введите Password !!!", Toast.LENGTH_SHORT).show();
        } else if (etUserName.getText().toString().equals("")) {
            Toast.makeText(ActivityCreateAccount.this, "Введите First & last name!!!", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.buttonSave) {
            String displayName = etUserName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            registration(displayName, email, password);
        }
    }

    //-----Регистрация в базе данных нового пользователя
    public void registration(final String userName, final String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ActivityCreateAccount.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                            String userKey = mAuth.getCurrentUser().getUid(); //получение личного ключа пользователя
                            databaseReference.child(userKey).setValue(userName);
                            //-----Отправка сообщения на Gmail о регистрации
                            mAuth.getCurrentUser().sendEmailVerification();
                        } else {
                            Toast.makeText(ActivityCreateAccount.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                        }


                        // ...

                    }

                });
    }
}

