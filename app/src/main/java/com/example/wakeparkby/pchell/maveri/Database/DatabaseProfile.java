package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.SignIn.ActivitySignIn;
import com.example.wakeparkby.pchell.maveri.SignIn.AdapterSignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseProfile {
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRefProfile;
    private String userId;
    private String firstName;
    private String lastName;
    private String age;
    private String sex;
    private String listInterests;
    private String profileUserName;
    private String profileUserLastName;
    private String profileUserAge;
    private String profileUserSex;
    private static ArrayList<ProfileFriend> Friends=new ArrayList<>();


    public DatabaseProfile(String listInterests , String id, String firstName, String lastName, String age, String sex) {
        this.listInterests = listInterests;
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        SetProfileDatabase();
    }
    public DatabaseProfile(){}

    private void SetProfileDatabase() {
        myRefProfile = database.getReference("/" + userId);
        myRefProfile.child("First name:").setValue(firstName);
        myRefProfile.child("Last name:").setValue(lastName);
        myRefProfile.child("Age:").setValue(age);
        myRefProfile.child("Sex:").setValue(sex);
        myRefProfile.child("Interests:").setValue(listInterests);

    }

    private void GetProfileDatabase() {
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot userTasksDS) {
                final List<String> userTaskList = new ArrayList<String>();
                for (DataSnapshot battle : userTasksDS.getChildren()){
                    if (battle.getKey().equals("First name: ")){
                        profileUserName = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Last name: ")){
                        profileUserLastName = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Age: ")){
                        profileUserAge = String.valueOf(battle.getValue());
                    }
                    else if (battle.getKey().equals("Sex: ")){
                        profileUserSex = String.valueOf(battle.getValue());
                    }
                }
                //ActivityProfile activityProfile = new ActivityProfile(profileUserName,profileUserLastName,profileUserAge,profileUserSex);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void loadUserInfo(final String userId) {
        this.userId = userId;
        myRefProfile = database.getReference("Users"+"/" + userId );
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
                public void onDataChange( DataSnapshot giveSeasonTicketDS) {
                firstName = String.valueOf(giveSeasonTicketDS.child("FirstName").getValue());
                lastName = String.valueOf(giveSeasonTicketDS.child("LastName").getValue());
                age = String.valueOf(giveSeasonTicketDS.child("Age").getValue());
                sex = String.valueOf(giveSeasonTicketDS.child("Sex").getValue());
                listInterests = String.valueOf(giveSeasonTicketDS.child("Interests").getValue());
                loadListFriends();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadListFriends(){

        myRefProfile = database.getReference("Users"+"/" + userId + "/Friends");
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot getListFriendsDS) {
                final List<String> friendsList = new ArrayList<>();
                for (DataSnapshot data : getListFriendsDS.getChildren())
                    friendsList.add(String.valueOf(data.getKey()));
                Friends.clear();

                for (int i = 0 ; i< friendsList.size();i++){
                    final String id = friendsList.get(i);
                    myRefProfile = database.getReference("Users"+"/" + id);
                    myRefProfile.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot getInfoFriendsDS) {
                            firstName = String.valueOf(getInfoFriendsDS.child("FirstName").getValue());
                            lastName = String.valueOf(getInfoFriendsDS.child("LastName").getValue());
                            age = String.valueOf(getInfoFriendsDS.child("Age").getValue());
                            sex = String.valueOf(getInfoFriendsDS.child("Sex").getValue());
                            listInterests = String.valueOf(getInfoFriendsDS.child("Interests").getValue());
                            ProfileFriend profileFriend=new ProfileFriend(id,firstName,lastName,age,sex,listInterests);
                            Friends.add(profileFriend);
                            AdapterSignIn adapterSignIn = new AdapterSignIn(userId, firstName,lastName,age, sex, listInterests);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public ArrayList<ProfileFriend> getFriends() {
        return Friends;
    }

    public void newProfile(String userKey, String firstName, String lastName, String age, String interests){
    myRefProfile = database.getReference("Users"+"/" + userKey );
        myRefProfile.child("FirstName").setValue(firstName);
        myRefProfile.child("LastName").setValue(lastName);
        myRefProfile.child("Age").setValue(age);
        myRefProfile.child("Interests").setValue(interests);
        myRefProfile.child("Sex").setValue("M");
    }


}
