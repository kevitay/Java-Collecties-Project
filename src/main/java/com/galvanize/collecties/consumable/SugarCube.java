package com.galvanize.collecties.consumable;

public class SugarCube implements Consumable {

    private int cubes = 2;

    @Override
    public String getName() {
        return String.format(
                "Triceratops Sugar Cubes (%d)",
                cubes);
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
