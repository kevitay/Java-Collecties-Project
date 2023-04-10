package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Batman extends Collectie {

    public Batman(){super (CollectieType.SPECIAL, "pow");

    }


    @Override
    public String getGraphic() {
        return "\n" +
                "          .  .\n" +
                "          |\\_|\\\n" +
                "          | a_a\\\n" +
                "          | | \"]\n" +
                "      ____| '-\\___\n" +
                "     /.----.___.-'\\\n" +
                "    //        _    \\\n" +
                "   //   .-. (~v~) /|\n" +
                "  |'|  /\\:  .--  / \\\n" +
                " // |-/  \\_/____/\\/~|\n" +
                "|/  \\ |  []_|_|_] \\ |\n" +
                "| \\  | \\ |___   _\\ ]_}\n" +
                "| |  '-' /   '.'  |\n" +
                "| |     /    /|:  | \n" +
                "| |     |   / |:  /\\\n" +
                "| |     /  /  |  /  \\\n" +
                "| |    |  /  /  |    \\\n" +
                "\\ |    |/\\/  |/|/\\    \\\n" +
                " \\|\\ |\\|  |  | / /\\/\\__\\\n" +
                "  \\ \\| | /   | |__\n" +
                "       / |   |____)\n" +
                "       |_/";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.SAVANNA;
    }

    @Override
    public int performAttack() {
        return 100;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Batman clone() {
        return new Batman();
    }
}
