package com.example.wakeparkby.pchell.maveri.Database;

import android.support.annotation.NonNull;

import com.example.wakeparkby.pchell.maveri.Friend.AdapterFriendList;
import com.example.wakeparkby.pchell.maveri.Friend.FriendListFragment;
import com.example.wakeparkby.pchell.maveri.Profile.Profile;
import com.example.wakeparkby.pchell.maveri.Profile.ProfileFriend;
import com.example.wakeparkby.pchell.maveri.SignIn.AdapterSignIn;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.Nullable;

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
    private AdapterFriendList friends = new AdapterFriendList();
    private static ArrayList<ProfileFriend> searchProfiles=new ArrayList<>();
    private String searchRequest="";

    public static ArrayList<ProfileFriend> getSearchProfiles() {
        return searchProfiles;
    }

    public DatabaseProfile() {
    }

    private void SetProfileDatabase() {
        myRefProfile = database.getReference("/" + userId);
        myRefProfile.child("First name:").setValue(firstName);
        myRefProfile.child("Last name:").setValue(lastName);
        myRefProfile.child("Age:").setValue(age);
        myRefProfile.child("Sex:").setValue(sex);
        myRefProfile.child("Interests:").setValue(listInterests);

    }

    /*private void GetProfileDatabase() {
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }*/

    public void loadUserInfo(final String userId) {
        this.userId = userId;
        myRefProfile = database.getReference("Users" + "/" + userId);
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot giveSeasonTicketDS) {
                firstName = String.valueOf(giveSeasonTicketDS.child("FirstName").getValue());
                lastName = String.valueOf(giveSeasonTicketDS.child("LastName").getValue());
                age = String.valueOf(giveSeasonTicketDS.child("Age").getValue());
                sex = String.valueOf(giveSeasonTicketDS.child("Sex").getValue());
                listInterests = String.valueOf(giveSeasonTicketDS.child("Interests").getValue());
                AdapterSignIn adapterSignIn = new AdapterSignIn(userId, firstName, lastName, age, sex, listInterests);
                loadListFriends();

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void loadListFriends() {

        myRefProfile = database.getReference("Users" + "/" + userId + "/Friends");
        myRefProfile.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot getListFriendsDS) {
                final List<String> friendsList = new ArrayList<>();
                for (DataSnapshot data : getListFriendsDS.getChildren())
                    friendsList.add(String.valueOf(data.getKey()));
                myRefProfile = database.getReference("Users" + "/");
                myRefProfile.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot getInfoFriendsDS) {
                        for (int i = 0; i < friendsList.size(); i++) {
                            final String id = friendsList.get(i);
                            firstName = String.valueOf(getInfoFriendsDS.child(id).child("FirstName").getValue());
                            lastName = String.valueOf(getInfoFriendsDS.child(id).child("LastName").getValue());
                            age = String.valueOf(getInfoFriendsDS.child(id).child("Age").getValue());
                            sex = String.valueOf(getInfoFriendsDS.child(id).child("Sex").getValue());
                            listInterests = String.valueOf(getInfoFriendsDS.child(id).child("Interests").getValue());
                            ProfileFriend profileFriend = new ProfileFriend(id, firstName, lastName, age, sex, listInterests);
                            friends.add(profileFriend);
                        }
                        Profile profile = Profile.getInstance();
                        profile.setFriendList(friends);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void newProfile(String userKey, String firstName, String lastName, String age, String interests) {
        myRefProfile = database.getReference("Users" + "/" + userKey);
        myRefProfile.child("FirstName").setValue(firstName);
        myRefProfile.child("LastName").setValue(lastName);
        myRefProfile.child("Age").setValue(age);
        myRefProfile.child("Interests").setValue(interests);
        myRefProfile.child("Sex").setValue("M");
    }


    private ProfileFriend setDataProfile(DataSnapshot getInfoFriendsDS,ArrayList<ProfileFriend> profiles,String id)
    {
        firstName = String.valueOf(getInfoFriendsDS.child("FirstName").getValue());
        lastName = String.valueOf(getInfoFriendsDS.child("LastName").getValue());
        age = String.valueOf(getInfoFriendsDS.child("Age").getValue());
        sex = String.valueOf(getInfoFriendsDS.child("Sex").getValue());
        listInterests = String.valueOf(getInfoFriendsDS.child("Interests").getValue());
        ProfileFriend profile=new ProfileFriend(id,firstName,lastName,age,sex,listInterests);
        profiles.add(profile);
        return  profile;

    }
    public void SearchProfile(String string)
    {
        //здесь должен быть код на Scala в 3 трочки
        if (!string.isEmpty() && !searchRequest.isEmpty()){
            if  (string.endsWith(searchRequest) || string.startsWith(searchRequest)) {
                for (ProfileFriend profile : searchProfiles) {
                    if (!profile.getLastName().startsWith(string) && !profile.getLastName().endsWith(string))
                        searchProfiles.remove(profile);
                }
                searchRequest = string;
            } else getListSearchProfile(string);
        } else {
            getListSearchProfile(string);
        }

    }


    private void getListSearchProfile(String parametr) {
        final ArrayList<ProfileFriend> searchProfile = new ArrayList<>();
        myRefProfile = database.getReference("Users");
        Query query = myRefProfile.orderByChild("LastName").startAt(parametr)
                .endAt(parametr + "\uf8ff");
        searchProfiles.clear();
        FriendListFragment.getArrayAdapter().addAll(searchProfiles);
        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot data, @Nullable String s) {
                final ArrayList<String> searchList = new ArrayList<>();
                searchList.add(String.valueOf(data.getKey()));
                for (final String search : searchList) {
                    myRefProfile = database.getReference("Users" + "/" + search);
                    myRefProfile.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot getInfoFriendsDS) {


                            FriendListFragment.getArrayAdapter().add(setDataProfile(getInfoFriendsDS,searchProfiles,search));
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot getListSearchDS, @Nullable String s) {
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
