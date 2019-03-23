package com.example.wakeparkby.pchell.maveri;

public class ObserverMessage {

    private static ObserverMessage instance;

    static public ObserverMessage getInstance() {
        if (instance == null) {
            instance = new ObserverMessage();
        }
            return instance;

    }

    private int n;

    public void setN(int n){
        this.n = n;
    }

    public int getN(){
        return this.n;
    }
}
