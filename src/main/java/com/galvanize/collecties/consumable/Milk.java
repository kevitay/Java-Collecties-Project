package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Milk implements Consumable {

    @Override
    public String getName() {
        return "carton of Milk (It does the body good!)";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new Milk();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.TAIGA;
    }
}
