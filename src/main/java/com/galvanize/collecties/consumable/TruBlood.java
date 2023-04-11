package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class TruBlood implements Consumable {
    @Override
    public String getName() {
        return "You quench your thirst for blood with a pint of TruBlood.";
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
