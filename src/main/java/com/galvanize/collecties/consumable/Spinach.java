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
        if(cans == 0) return true;

        cans--;
        return cans == 0;
    }

    @Override
    public Consumable clone() {
        return null;
    }
}
