package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.support.v7.app.*;
import View.*;

public class ActivityCreateProfile extends AppCompatActivity implements OnClickListener {

	private com.google.firebase.auth.FirebaseAuth mAuth;
	java.util.ArrayList<String> interests = new ArrayList<String>();
	android.widget.ArrayAdapter adapter;
	android.widget.ListView listMain;
	android.widget.TextView selection;
	private android.widget.Button countiusButton;
	private String interestString;
	private android.widget.EditText editTextName;
	private android.widget.EditText editTextSecond;
	private android.widget.EditText editTextAge;
	private String firstName;
	private String lastName;
	private String age;
	private static String userKey;
	ChangeToArray changeToArray = new ChangeToArray();

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

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
	 * private void setupViewPager(ViewPager viewPager) {
	 * ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
	 * adapter.addFragment(new String(), "People");
	 * adapter.addFragment(new String(), "Group");
	 * adapter.addFragment(new String(), "Calls");
	 * viewPager.setAdapter(adapter);
	 * }
	 * @return 
	 */
	private void getInterestMain() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param v
	 * @return 
	 */
	@Override
	public void onClick(android.view.View v) {
		throw new UnsupportedOperationException();
	}

}