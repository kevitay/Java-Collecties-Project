package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

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
        if (cubes == 0) return true;

        cubes--;
        return cubes == 0;
    }

    @Override
    public Consumable clone() {
        return new SugarCube();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.SAVANNA;
    }
}
