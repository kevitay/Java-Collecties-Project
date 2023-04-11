package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class AnabolicSteroids implements Consumable{


    @Override
    public String getName() {
        return "The steroids is working! You're now jacked!";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone()  {
        return new AnabolicSteroids();
    }

    @Override
    public Biome getContainingBiome() {
        return Biome.BOG;
    }
}
