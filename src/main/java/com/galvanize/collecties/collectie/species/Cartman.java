package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Cartman extends Collectie {
    public Cartman() {super (CollectieType.GHOST,  "RESPECT MY AUTHORITY"); }


    @Override
    public String getGraphic() {
        return "      _._\n" +
                "           __.{,_.).__\n" +
                "        .-\"           \"-.\n" +
                "      .'  __.........__  '.\n" +
                "     /.-'`___.......___`'-.\\\n" +
                "    /_.-'` /   \\ /   \\ `'-._\\\n" +
                "    |     |   '/ \\'   |     |\n" +
                "    |      '-'     '-'      |\n" +
                "    ;                       ;\n" +
                "    _\\         ___         /_\n" +
                "   /  '.'-.__  ___  __.-'.'  \\\n" +
                " _/_    `'-..._____...-'`    _\\_\n" +
                "/   \\           .           /   \\\n" +
                "\\____)         .           (____/\n" +
                "    \\___________.___________/\n" +
                "      \\___________________/\n" +
                "      (_____________________)";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.MOUNTAIN_RANGE;
    }

    @Override
    public int performAttack() {
        return 100;
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
