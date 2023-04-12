package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class TruBlood implements Consumable {
    @Override
    public String getName() {
        return "pint of TruBlood";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new TruBlood();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.OCEANIC;
    }
}
