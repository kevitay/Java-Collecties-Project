package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Dinghy implements Consumable {

    private int bites = 2;
    @Override
    public String getName() {
        return String.format("You bite off a chunk of a dinghy (%d)", this.bites);
    }

    @Override
    public boolean consume() {
        if(this.bites == 0)
            return true;
        this.bites--;
        return this.bites == 0;
    }

    @Override
    public Consumable clone() {
        return new Dinghy();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.OCEANIC;
    }
}
