package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class KonaCoffee implements Consumable {
    @Override
    public String getName() {
        return "Kona Coffee";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new KonaCoffee();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.VOLCANIC;
    }
}
