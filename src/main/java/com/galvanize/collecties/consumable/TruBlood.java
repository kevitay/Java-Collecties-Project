package com.galvanize.collecties.consumable;

public class TruBlood implements Consumable {
    @Override
    public String getName() {
        return "You quench your thirst for blood with a pint of TruBlood.";
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
