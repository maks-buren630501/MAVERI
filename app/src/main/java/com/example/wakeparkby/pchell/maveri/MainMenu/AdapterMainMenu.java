package com.example.wakeparkby.pchell.maveri.MainMenu;

import com.example.wakeparkby.pchell.maveri.Database.DatabaseProfile;
import com.google.firebase.auth.FirebaseAuth;

public class AdapterMainMenu {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private String userId = mAuth.getCurrentUser().getUid();
    public void getUserInfo() {
        DatabaseProfile databaseProfile = new DatabaseProfile();
        databaseProfile.getUserInfo(userId);
    }
}
