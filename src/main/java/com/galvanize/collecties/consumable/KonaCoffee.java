package com.galvanize.collecties.consumable;

public class KonaCoffee implements Consumable {
    @Override
    public String getName() {
        return "Kona Coffee";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new KonaCoffee();
    }
}
