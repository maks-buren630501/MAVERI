package com.example.wakeparkby.pchell.maveri.CreateAccount;

import java.util.ArrayList;
import java.lang.String;

public class AllDataProfile {

    private ListInterests listInterests=new ListInterests();
    private static String stringInterests;
    static int positionLowList;

    public String[] GetStringLowInterests(int position) {
        ArrayList<String> listKey = new ArrayList<String>(listInterests.hashMap.keySet());
        return listInterests.hashMap.get(listKey.get(position));

    }

    public ArrayList<String> toArray(int position) {
        ArrayList<String> stringArrayList=new ArrayList<String>();
        String[] strings=GetStringLowInterests(position);
       for(String s: strings){
           stringArrayList.add(s);

       }
        return stringArrayList ;
    }

    public ArrayList<String> GetStringHighInterests()
    {
        ArrayList<String> listKey = new ArrayList<String>(listInterests.hashMap.keySet());
        return listKey;
    }

    public static String getStringInterests() {
        return stringInterests;
    }

    public static void setStringInterests(String stringInterests) {
        AllDataProfile.stringInterests = stringInterests;
    }
}

