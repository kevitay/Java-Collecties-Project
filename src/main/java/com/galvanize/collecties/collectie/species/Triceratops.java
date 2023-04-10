package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Triceratops extends Collectie {

    public Triceratops() {
        super(CollectieType.DINOSAUR, "roar");
    }

    public String getGraphic() {
        return " test";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.PLAINS;
    }

    @Override
    public int performAttack() {
        return 70;
    }

    @Override
    public boolean defend(int attackStrength) {
        return false;
    }

    @Override
    public Collectie clone() {
        return null;
    }
}
