package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
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
                " jgs  `._    `-._       _.-'    _.'\n" +
                "       .'`-.__ .'`-._.-'`. __.-'`.\n" +
                "     .'       `.         .'       `.\n" +
                "   .'           `-.   .-'           `.";
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
