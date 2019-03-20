package com.example.wakeparkby.pchell.maveri.Database;

public class DatabaseMessage {

	private com.google.firebase.database.FirebaseDatabase database = FirebaseDatabase.getInstance();
	private com.google.firebase.database.DatabaseReference myRefMeessage;
	private static String groupID;

	/**
	 * 
	 * @param groupId
	 * @return 
	 */
	public void setId(String groupId) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param name
	 * @param time
	 * @param message
	 * @return 
	 */
	public void sendMessage(String name, String time, String message) {
		throw new UnsupportedOperationException();
	}

}