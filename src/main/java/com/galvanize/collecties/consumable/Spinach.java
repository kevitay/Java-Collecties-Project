package com.galvanize.collecties.consumable;

public class Spinach implements Consumable {

    private int cans = 2;
    @Override
    public String getName() {
        return String.format(
                "Popeye's brand spinach (%d) - gives incredible strength!",
                cans);
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
