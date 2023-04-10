package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Triceratops extends Collectie {

    public Triceratops() {
        super(CollectieType.DINOSAUR, "roar");
    }

    public String getGraphic() {
        return "                       _. - ~ ~ ~ - .\n" +
                "   ..       __.    .-~               ~-.\n" +
                "   ((\\     /   `}.~                     `.\n" +
                "    \\\\\\   {     }               /     \\   \\\n" +
                "(\\   \\\\~~^      }              |       }   \\\n" +
                " \\`.-~ -@~      }  ,-.         |       )    \\\n" +
                " (___     ) _}   (    :        |    / /      `.\n" +
                "  `----._-~.     _\\ \\ |_       \\   / /- _      `.\n" +
                "         ~~----~~  \\ \\| ~~--~~~(  + /     ~-.     ~- _\n" +
                "                   /  /         \\  \\          ~- . _ _~_-_.\n" +
                "                __/  /          _\\  )\n" +
                "              .<___.'         .<___/";
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
        if(Game.TEST_MODE) return false;
        return  Game.randogen.nextInt(100) > 25;
    }

    @Override
    public Triceratops clone() {
        return new Triceratops();
    }
}
