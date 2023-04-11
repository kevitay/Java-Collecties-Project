package com.galvanize.collecties.consumable;

public class VeganHotdogs implements Consumable{
    @Override
    public String getName() {
        return "VeganHotdogs";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new VeganHotdogs();
    }



}
