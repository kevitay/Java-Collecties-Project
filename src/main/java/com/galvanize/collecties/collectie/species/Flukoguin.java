package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Flukoguin extends Collectie {

    public Flukoguin() {
        super(CollectieType.SPECIAL, "Yabbadabbayoo");
    }

    @Override
    public String getGraphic() {
        return "                     /\\         /\\__\n" +
                "                   // \\       (  0 )_____/\\            __\n" +
                "                  // \\ \\     (vv          o|          /^v\\\n" +
                "                //    \\ \\   (vvvv  ___-----^        /^^/\\vv\\\n" +
                "              //  /     \\ \\ |vvvvv/               /^^/    \\v\\\n" +
                "             //  /       (\\\\/vvvv/              /^^/       \\v\\\n" +
                "            //  /  /  \\ (  /vvvv/              /^^/---(     \\v\\\n" +
                "           //  /  /    \\( /vvvv/----(O        /^^/           \\v\\\n" +
                "          //  /  /  \\  (/vvvv/               /^^/             \\v|\n" +
                "        //  /  /    \\( vvvv/                /^^/               ||\n" +
                "       //  /  /    (  vvvv/                 |^^|              //\n" +
                "      //  / /    (  |vvvv|                  /^^/            //\n" +
                "     //  / /   (    \\vvvvv\\          )-----/^^/           //\n" +
                "    // / / (          \\vvvvv\\            /^^^/          //\n" +
                "   /// /(               \\vvvvv\\        /^^^^/          //\n" +
                "  ///(              )-----\\vvvvv\\    /^^^^/-----(      \\\\\n" +
                " //(                        \\vvvvv\\/^^^^/               \\\\\n" +
                "/(                            \\vvvv^^^/                 //\n" +
                "                                \\vv^/         /        //\n" +
                "                                             /<______//\n" +
                "                                            <<<------/\n" +
                "                                             \\<\n" +
                "                                               \\";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.TAIGA;
    }

    @Override
    public int performAttack() {
        return 75;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Flukoguin clone() {
        return new Flukoguin();
    }
}
