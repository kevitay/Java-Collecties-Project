package com.galvanize.collecties.consumable;

public class Bananas implements Consumable {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean consume() {
        return false;
    }

    @Override
    public Consumable clone() {
        return null;
    }
}
