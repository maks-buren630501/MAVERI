package com.example.wakeparkby.pchell.maveri.SignIn;

import android.support.v7.app.*;
import View.*;

public class ActivitySignIn extends AppCompatActivity implements OnClickListener {

	private com.google.firebase.auth.FirebaseAuth mAuth = FirebaseAuth.getInstance();
	private com.google.firebase.auth.FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
	private android.widget.EditText etEmail;
	private android.widget.EditText etPassword;
	private android.widget.TextView textViewNewPassword;
	private android.widget.TextView textViewCreateAccount;
	private android.widget.Button buttonEnter;

	/**
	 * 
	 * @param savedInstanceState
	 * @return 
	 */
	@Override
	protected void onCreate(android.os.Bundle savedInstanceState) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param view
	 * @return 
	 */
	@Override
	public void onClick(android.view.View view) {
		throw new UnsupportedOperationException();
	}

	/**
	 * -----Проверка авторизации
	 * @param email_S
	 * @param password_S
	 * @return 
	 */
	public void signIn(String email_S, String password_S) {
		throw new UnsupportedOperationException();
	}

}