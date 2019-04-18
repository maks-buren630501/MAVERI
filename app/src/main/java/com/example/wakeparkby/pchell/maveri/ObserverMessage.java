package com.example.wakeparkby.pchell.maveri;

import java.util.ArrayList;
import java.util.List;

/**
 * класс с реализацией наблюдателя для сообщений
 */
public class ObserverMessage {

    private static List<ObserverMessage> observers = new ArrayList<>();

    private static int id;

    String name;

    int status = 10;

    /**
     * конструктор с параметрами
     * @param name имя наблюдателя
     */

    public ObserverMessage(String name) {
        this.name = name;
        observers.add(this);
    }


    /**
     * метод для установки статуса
     * @param status статус
     */

    public void setStatus(int status) {

        this.status = status;


    }


    /**
     * метод для установки номера наблюдателя
     * @param id номер наблюдателя
     */

    public void setId(int id) {

        this.id = id;


    }


    /**
     * метод для получения номера
     * @return номер наблюдателя
     */

    public int getId() {

        return id;

    }


    /**
     * метод для получений статуса наблюдателя
     * @return статус наблюдателя
     */
    public int getStatus() {
        return status;
    }


    /**
     * метод для оповещения всех наблюдателей
     */

    public void notifyAllObservers() {

        for (ObserverMessage observer : observers) {

            observer.update();

        }

    }


    /**
     * метод для оповещения наблюдателей с номером
     * @param id номера наблюдателей
     */

    public void notifyAllObservers(int id) {

        this.setId(id);

        for (ObserverMessage observer : observers) {

            observer.update();

        }

    }


    /**
     * абстрактный метод обновления
     */

    public void update() {
    }

}