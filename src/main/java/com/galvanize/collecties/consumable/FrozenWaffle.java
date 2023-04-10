package com.galvanize.collecties.consumable;

public class FrozenWaffle implements Consumable {

    @Override
    public String getName() {
        return "Frozen waffle without any side dishes";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new FrozenWaffle();
    }


}
