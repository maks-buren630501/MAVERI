package com.example.wakeparkby.pchell.maveri.MainMenu;

public class AdapterMainMenu {

	private com.google.firebase.auth.FirebaseAuth mAuth = FirebaseAuth.getInstance();
	private String userId = mAuth.getCurrentUser().getUid();

	/**
	 * 
	 * @return 
	 */
	public void getUserInfo() {
		throw new UnsupportedOperationException();
	}

}