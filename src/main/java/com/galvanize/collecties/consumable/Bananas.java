package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Bananas implements Consumable {

    private int naners = 6;

    @Override
    public String getName() {
        return String.format("Bunch of Bananas (%d)",
                naners);
    }

    @Override
    public boolean consume() {
        if(naners == 0) return true;

        naners--;
        return naners == 0;
    }

    @Override
    public Consumable clone() {
        return new Bananas();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.RAINFOREST;
    }

}
