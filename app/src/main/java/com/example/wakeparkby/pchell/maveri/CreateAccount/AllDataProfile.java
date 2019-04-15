package com.example.wakeparkby.pchell.maveri.CreateAccount;

import java.util.ArrayList;
import java.lang.String;

/**
 * класс для хранения данных пользователей
 */
public class AllDataProfile {

    private ListInterests listInterests=new ListInterests();
    private static String stringInterests;
    static int positionLowList;

    /**
     * метод для преобразования строки в hashmap
     * @param position позиция интереса в списке
     * @return hashmap интересов
     */
    public String[] GetStringLowInterests(int position) {
        ArrayList<String> listKey = new ArrayList<String>(listInterests.hashMap.keySet());
        return listInterests.hashMap.get(listKey.get(position));

    }

    /**
     * метод возврощающий лист интересов из встреч
     * @param position позиция интереса в списке
     * @return список интересов пользователя
     */
    public ArrayList<String> toArray(int position) {
        ArrayList<String> stringArrayList=new ArrayList<String>();
        String[] strings=GetStringLowInterests(position);
       for(String s: strings){
           stringArrayList.add(s);

       }
        return stringArrayList ;
    }

    /**
     * метод возврощающий список выбранных интересов
     * @return список выбранных интересов
     */
    public ArrayList<String> GetStringHighInterests()
    {
        ArrayList<String> listKey = new ArrayList<String>(listInterests.hashMap.keySet());
        return listKey;
    }

    /**
     * метод возвращающий строку интересов
     * @return строка интересов
     */
    public static String getStringInterests() {
        return stringInterests;
    }

    /**
     * метод устанавливающий строку интересов
     * @param stringInterests строка интересов
     */
    public static void setStringInterests(String stringInterests) {
        AllDataProfile.stringInterests = stringInterests;
    }
}

