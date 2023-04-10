package com.galvanize.collecties.consumable;

public class Milk implements Consumable {

    @Override
    public String getName() {
        return "Skeletor strengthens bones with milk it does the body good";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return null;
    }
}
