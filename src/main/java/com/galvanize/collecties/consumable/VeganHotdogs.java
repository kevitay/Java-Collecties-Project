package com.galvanize.collecties.consumable;

public class VeganHotdogs implements Consumable{

    private int veganHotdogs = 2;
    @Override
    public String getName() {
        return "VeganHotdogs";
    }

    @Override
    public boolean consume() {
        if (veganHotdogs == 0) return true;

        veganHotdogs--;
        return veganHotdogs == 0;
    }

    @Override
    public Consumable clone() {
        return new VeganHotdogs();
    }



}
