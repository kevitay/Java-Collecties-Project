package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Vampire extends Collectie {

    public Vampire() {
        super(CollectieType.SPECIAL, "I want to suck your blood");
    }

    @Override
    public String getGraphic() {
        return "              __.......__\n" +
                "            .-:::::::::::::-.\n" +
                "          .:::''':::::::''':::.\n" +
                "        .:::'     `:::'     `:::. \n" +
                "   .'\\  ::'   ^^^  `:'  ^^^   '::  /`.\n" +
                "  :   \\ ::   _.__       __._   :: /   ;\n" +
                " :     \\`: .' ___\\     /___ `. :'/     ; \n" +
                ":       /\\   (_|_)\\   /(_|_)   /\\       ;\n" +
                ":      / .\\   __.' ) ( `.__   /. \\      ;\n" +
                ":      \\ (        {   }        ) /      ; \n" +
                " :      `-(     .  ^\"^  .     )-'      ;\n" +
                "  `.       \\  .'<`-._.-'>'.  /       .'\n" +
                "    `.      \\    \\;`.';/    /      .'\n" +
                "      `._    `-._       _.-'    _.'\n" +
                "       .'`-.__ .'`-._.-'`. __.-'`.\n" +
                "     .'       `.         .'       `.\n" +
                "   .'           `-.   .-'           `.";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.MOUNTAIN_RANGE;
    }

    @Override
    public int performAttack() {
        return 8;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 20;
    }

    @Override
    public Collectie clone() {
        return new Vampire();
    }
}
