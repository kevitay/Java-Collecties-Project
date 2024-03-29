package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Galva extends Collectie {
    public Galva() {
        super(CollectieType.ELEMENTAL, "zzzzzzaaaaaapppppp");
    }

    @Override
    public String getGraphic() {
        return "     _, .--.\n" +
                "    (  / (  '-.\n" +
                "    .-=-.    ) -.\n" +
                "   /   (  .' .   \\\n" +
                "   \\ ( ' ,_) ) \\_/\n" +
                "    (_ , /\\  ,_/\n" +
                "      '--\\  \\--`\n" +
                "         _\\ _\\\n" +
                "         \\ \\\n" +
                "         _\\_\\\n" +
                "          \\\\\n" +
                "           \\\\\n" +
                "        -.'.`\\.'.-";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.PLAINS;
    }

    @Override
    public int performAttack() {
        return 15;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 25;
    }

    @Override
    public Galva clone() {
        return new Galva();
    }
}
