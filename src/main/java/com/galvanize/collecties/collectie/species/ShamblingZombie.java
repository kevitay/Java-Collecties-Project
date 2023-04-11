package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class ShamblingZombie extends Collectie {
    public ShamblingZombie() {
        super(CollectieType.GHOST, "A MIND IS A TERRIBLE THING TO WASTE");
    }

    @Override
    public String getGraphic() {
        return  "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢠⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣷⣶⣄⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣷⡀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠘⠿⢻⣿⣿⡄\n" +
                "⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠸⠋⢿⣇\n" +
                "⠀⢀⣾⣿⣿⢿⣿⣿⠟⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀⠁\n" +
                "⣶⣿⣿⢿⣯⣼⡿⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
                "⠘⠻⠟⠀⠉⡿⠁⠀⠀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡇⢿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⡟⠀⠸⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⡇⠀⠀⢿⣿⣿⣧⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⣿⣿⠋⠀⠀⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⣿⣿⣿⠄⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⢿⣿⣿⡄⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⢘⣿⣿⣧⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢿⣿⣷⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    }
    @Override
    public Biome getPreferredBiome() {
        return Biome.BOG;
    }

    @Override
    public int performAttack() {
        return 8;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public ShamblingZombie clone() {
        return new ShamblingZombie();
    }
}
