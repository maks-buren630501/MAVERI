package com.example.wakeparkby.pchell.maveri.Profile;

/**
 * String userKey = mAuth.getCurrentUser().getUid();  получение userkey
 */
public class Profile {

	private com.google.firebase.auth.FirebaseAuth mAuth = FirebaseAuth.getInstance();
	private String userId = mAuth.getCurrentUser().getUid();
	private static String userKey;
	private static String firstName;
	private String lastName;
	private String age;
	private String sex;
	private String listInterests;
	private static String userFirstName;
	private static String userLastName;
	private static String userAge;
	private static String userSex;
	private static String userListInterests;

	public String getUserId() {
		return this.userId;
	}

	public String getUserKey() {
		return this.userKey;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getAge() {
		return this.age;
	}

	public String getSex() {
		return this.sex;
	}

	public String getListInterests() {
		return this.listInterests;
	}

	public String getUserFirstName() {
		return this.userFirstName;
	}

	public String getUserLastName() {
		return this.userLastName;
	}

	public String getUserAge() {
		return this.userAge;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public String getUserListInterests() {
		return this.userListInterests;
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return 
	 */
	public Profile(String firstName, String lastName) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param sex
	 * @param listInterests
	 * @return 
	 */
	public Profile(String id, String firstName, String lastName, String age, String sex, String listInterests) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public void getUserInfo() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param sex
	 * @param listInterests
	 * @return 
	 */
	public Profile(String firstName, String lastName, String age, String sex, String listInterests) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @return 
	 */
	public Profile() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userKey
	 * @return 
	 */
	public Profile(String userKey) {
		throw new UnsupportedOperationException();
	}

}