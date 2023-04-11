package com.galvanize.collecties.consumable;

public class CheesyPoofs implements Consumable{

    Integer poofs = 15;
    @Override
    public String getName() {
        return String.format("CheesyPoofs (%d)", poofs);
    }

    @Override
    public boolean consume() {
        if (poofs == 0) {
            return true;
        }
        poofs--;

        return poofs == 0;
    }

    @Override
    public Consumable clone() {
        return new CheesyPoofs();
    }
}
