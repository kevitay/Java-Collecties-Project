package com.galvanize.collecties.consumable;

public class CheesyPoofs implements Consumable{

    Integer poofs = 15;
    @Override
    public String getName() {
        return String.format("CheesyPoofs (%d)", poofs);
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
