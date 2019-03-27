package com.example.wakeparkby.pchell.maveri.CreateAccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.wakeparkby.pchell.maveri.R;
import java.util.ArrayList;

public class ActivityChooseLowInterests extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> lowInterests = new ArrayList<String>();
    ArrayAdapter adapter;
    ListView listMain;
    AllDataProfile allDataProfile=new AllDataProfile();

    private String interestString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_of_interests_list);


        getInterestLowInterests(AllDataProfile.positionLowList);

        listMain = findViewById(R.id.listLowInterests);
        listMain.setChoiceMode(listMain.CHOICE_MODE_MULTIPLE);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, lowInterests);
        listMain.setAdapter(adapter);


        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                SparseBooleanArray chosen = ((ListView) parent).getCheckedItemPositions();
                for (int i = 0; i < chosen.size(); i++) {
                    if (chosen.valueAt(i)) {
                        interestString=lowInterests.get(chosen.keyAt(i))+", ";
                        System.out.print("");
                    }
                }
            }
        });

    }

    private void getInterestLowInterests(int position) {
        for (int i = 0; i <= allDataProfile.GetStringLowInterests(position).length - 1; i++) {
            lowInterests.add(allDataProfile.GetStringLowInterests(position)[i]);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
