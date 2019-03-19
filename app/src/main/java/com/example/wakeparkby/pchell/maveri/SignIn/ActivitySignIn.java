package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendList;
import com.example.wakeparkby.pchell.maveri.MainMenu.ActivityMainMenu;
import com.example.wakeparkby.pchell.maveri.CreateAccount.ActivityCreateAccount;
import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivitySignIn extends AppCompatActivity implements View.OnClickListener {
    AdapterSignIn adapterSignIn = new AdapterSignIn();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    private EditText etEmail;
    private EditText etPassword;

    private TextView textViewNewPassword;
    private TextView textViewCreateAccount;
    private Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        buttonEnter = findViewById(R.id.buttonEnter);
        textViewNewPassword = findViewById(R.id.textViewNewPassword);
        findViewById(R.id.buttonEnter).setOnClickListener(this);
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        findViewById(R.id.textViewCreateAccount).setOnClickListener(this);
        findViewById(R.id.textViewNewPassword).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent_CreateAccount = new Intent(this, ActivityCreateAccount.class);
        switch (view.getId()) {
            case R.id.buttonEnter:
                if (etEmail.getText().toString().equals("")) {
                    Toast.makeText(ActivitySignIn.this, "Введите Email !!!", Toast.LENGTH_SHORT).show();
                } else if (etPassword.getText().toString().equals("")) {
                    Toast.makeText(ActivitySignIn.this, "Введите Password !!!", Toast.LENGTH_SHORT).show();
                } else if (view.getId() == R.id.buttonEnter) {
                    signIn(etEmail.getText().toString(), etPassword.getText().toString());
                }
                break;
            case R.id.textViewNewPassword:
                if (etEmail.getText().toString().equals("")) {
                    Toast.makeText(ActivitySignIn.this, "Заполните поле EMAIL !!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivitySignIn.this, "Проверьте почту !!!", Toast.LENGTH_SHORT).show();
                    //-----Отправка сообщения о смене пароля
                    mAuth.sendPasswordResetEmail(etEmail.getText().toString());
                }
                break;
            case R.id.textViewCreateAccount:
                startActivity(intent_CreateAccount);
                break;
        }
    }

    //-----Проверка авторизации
    public void signIn(String email_S, String password_S) {
        mAuth.signInWithEmailAndPassword(email_S, password_S)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if (user.isEmailVerified() == true) {
                                Toast.makeText(ActivitySignIn.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                                adapterSignIn.getUserInfo(mAuth.getUid());

                                startActivityMainMenu();
                            }
                            //Проверка подтверждения аккаунта (почта Gmail)
                            if (user.isEmailVerified() == false) {
                                Toast.makeText(ActivitySignIn.this, "Нет подтверждения", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(ActivitySignIn.this, "Авторизация провалена", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void startActivityMainMenu() {
        AdapterSignIn.startActivityMainMenu(this);
    }
}