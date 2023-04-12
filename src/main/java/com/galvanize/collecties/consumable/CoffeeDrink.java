package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class CoffeeDrink implements Consumable{


    @Override
    public String getName() {
        return ( "Cartman's Super Terrific Coffee!");
    }
    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new CoffeeDrink();
    }

    @Override
    public Biome getContainingBiome(){
        return Biome.TUNDRA;
    }
}
