package com.galvanize.collecties.consumable;

public class TruBlood implements Consumable {
    @Override
    public String getName() {
        return "pint of TruBlood";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new TruBlood();
    }
}
