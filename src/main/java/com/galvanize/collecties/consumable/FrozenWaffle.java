package com.galvanize.collecties.consumable;

public class FrozenWaffle implements Consumable {

    private int slices = 2;
    @Override
    public String getName() {
        return String.format(
                "Frozen waffle without any side dishes (%d)",
                slices);
    }

    @Override
    public boolean consume() {
        if(slices == 0) return true;

        slices--;
        return slices == 0;
    }

    @Override
    public Consumable clone() {
        return new FrozenWaffle();
    }


}
