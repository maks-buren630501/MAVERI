package com.example.wakeparkby.pchell.maveri.SignIn;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.CreateAccount.ActivityCreateAccount;
import com.example.wakeparkby.pchell.maveri.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Vector;

public class ActivitySignIn extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    AdapterSignIn adapterSignIn = new AdapterSignIn();


    private EditText etEmail;
    private EditText etPassword;

    private TextView textViewNewPassword;
    private TextView textViewCreateAccount;
    private Button buttonEnter;

    private ImageView iMainPicture;
    private Animation aRotateEarth;
    boolean have= true;

    private RelativeLayout animationHuman;
    private ImageView imageViewHuman;
    AnimationThread animationThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etEmail = findViewById(R.id.editTextEmail);
        etPassword = findViewById(R.id.editTextPassword);
        buttonEnter = findViewById(R.id.buttonEnterNew);
        textViewNewPassword = findViewById(R.id.textViewNewPassword);
        findViewById(R.id.buttonEnterNew).setOnClickListener(this);
        textViewCreateAccount = findViewById(R.id.textViewCreateAccount);
        findViewById(R.id.textViewCreateAccount).setOnClickListener(this);
        findViewById(R.id.textViewNewPassword).setOnClickListener(this);

        animationHuman = findViewById(R.id.animationHuman);

        imageViewHuman = new ImageView(this);
        imageViewHuman.setImageResource(R.drawable.human_1);
        animationHuman.addView(imageViewHuman);


       iMainPicture = findViewById(R.id.imageViewEarth);
       aRotateEarth = AnimationUtils.loadAnimation(this, R.anim.move_earth);
       iMainPicture.startAnimation(aRotateEarth);

        animationThread = new AnimationThread(animationHuman, imageViewHuman);
        animationThread.start();

    }

    @Override
    public void onClick(View view) {

        Intent intent_CreateAccount = new Intent(this, ActivityCreateAccount.class);
        switch (view.getId()) {
            case R.id.buttonEnterNew:
                if (etEmail.getText().toString().equals("")) {
                    Toast.makeText(ActivitySignIn.this, "Введите Email !!!", Toast.LENGTH_SHORT).show();
                } else if (etPassword.getText().toString().equals("")) {
                    Toast.makeText(ActivitySignIn.this, "Введите Password !!!", Toast.LENGTH_SHORT).show();
                } else if (view.getId() == R.id.buttonEnterNew) {
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
                            if (user.isEmailVerified()) {
                                Toast.makeText(ActivitySignIn.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                                adapterSignIn.loadUserInfo(mAuth.getUid());
                                startActivityMainMenu();
                            }
                            //Проверка подтверждения аккаунта (почта Gmail)
                            if (!user.isEmailVerified()) {
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

    public class AnimationThread extends Thread {



        private Vector<Integer> iconsHuman;

        RelativeLayout animationHuman;

        //ImageView imageViewHuman;



        private int count_of_cycles = 0;



        AnimationThread(RelativeLayout relativeLayout, ImageView imageViewHuman) {

            this.animationHuman = relativeLayout;

            //  this.imageViewHuman = imageViewHuman;

        }



        @Override

        public void run() {

            do {

                runOnUiThread(new Runnable() {

                    @Override

                    public void run() {       // animationHuman.addView(imageViewHuman);

                        switch (count_of_cycles) {

                            case 1:

                                imageViewHuman.setImageResource(R.drawable.human_1);

                                break;

                            case 2:

                                imageViewHuman.setImageResource(R.drawable.human_2);

                                break;

                            case 3:

                                imageViewHuman.setImageResource(R.drawable.human_3);

                                break;

                            case 4:

                                imageViewHuman.setImageResource(R.drawable.human_4);

                                break;

                            case 5:

                                imageViewHuman.setImageResource(R.drawable.human_5);

                                break;

                            case 6:

                                imageViewHuman.setImageResource(R.drawable.human_6);

                                break;

                            case 7:

                                imageViewHuman.setImageResource(R.drawable.human_7);

                                break;

                            case 8:

                                imageViewHuman.setImageResource(R.drawable.human_8);

                                break;

                        }

                    }

                });



                count_of_cycles++;

                if (count_of_cycles == 8)

                    count_of_cycles = 0;



                try {

                    Thread.sleep(1000 / 7);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            } while (have);

        }

    }

}