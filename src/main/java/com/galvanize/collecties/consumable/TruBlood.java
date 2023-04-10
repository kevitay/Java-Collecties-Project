package com.galvanize.collecties.consumable;

public class TruBlood implements Consumable {
    @Override
    public String getName() {
        return "You quench your blood thirst with a pint of TruBlood.";
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
