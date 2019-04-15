package com.example.wakeparkby.pchell.maveri.CreateAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.lang.String;

/**
 * класс для преобразования строки в список
 */
public class ChangeToArray {

    private ListInterests listInterests = new ListInterests();

    /**
     * метод возврощающий строку интереса по позиции
     * @param position позиция интереса
     * @return строка интереса
     */
    public String[] GetStsring(int position) {
        ArrayList<String> listKey = new ArrayList<String>(listInterests.hashMap.keySet());
        return listInterests.hashMap.get(listKey.get(position));

    }

    /**
     * метод для преобразования строки в список
     * @param position позиция интереса в списке
     * @return список интересов
     */
    public ArrayList<String> toArray(int position) {
        ArrayList<String> stringArrayList = new ArrayList<String>();
        String[] strings = GetStsring(position);
        for (String s : strings) {
            stringArrayList.add(s);

        }
        return stringArrayList;

    }

}

