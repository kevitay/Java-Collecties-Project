package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Cartman extends Collectie {
    public Cartman() {super (CollectieType.SPECIAL,  "RESPECT MY AUTHORITY"); }


    @Override
    public String getGraphic() {
        return null;
    }

    @Override
    public Biome getPreferredBiome() {
        return null;
    }

    @Override
    public int performAttack() {
        return 0;
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
