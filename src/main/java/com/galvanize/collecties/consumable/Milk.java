package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Milk implements Consumable {

    @Override
    public String getName() {
        return "You strengthened your bones with milk it does the body good";
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
