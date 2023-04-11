package com.galvanize.collecties.collectie.species;


import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Yeti extends Collectie {

    public Yeti() {
        super(CollectieType.SPECIAL, "whistling swoosh");
    }
   public String getGraphic() {
     return "                  _         _\n" +
             " .-\"\"-.          ( )-\"```\"-( )          .-\"\"-.\n" +
             "/ O O  \\          /         \\          /  O O \\\n" +
             "|O .-.  \\        /   0 _ 0   \\        /  .-. O|\n" +
             "\\ (   )  '.    _|     (_)     |     .'  (   ) /\n" +
             " '.`-'     '-./ |             |`\\.-'     '-'.'\n" +
             "   \\         |  \\   \\     /   /  |         /\n" +
             "    \\        \\   '.  '._.'  .'   /        /\n" +
             "     \\        '.   `'-----'`   .'        /\n" +
             "      \\   .'    '-._        .-'\\   '.   /\n" +
             "       |/`          `'''''')    )    `\\|\n" +
             "       /                  (    (      ,\\\n" +
             "      ;                    \\    '-..-'/ ;\n" +
             "      |                     '.       /  |\n" +
             "      |                       `'---'`   |\n" +
             "      ;                                 ;\n" +
             "       \\                               /\n" +
             "        `.                           .'\n" +
             "          '-._                   _.-'\n" +
             "           __/`\"  '  - - -  ' \"`` \\__\n" +
             "         /`            /^\\           `\\\n" +
             "         \\(          .'   '.         )/\n" +
             "          '.(__(__.-'       '.__)__).' , \n";
   }

    @Override
    public Biome getPreferredBiome() {
        return Biome.MOUNTAIN_RANGE;
    }

    @Override
    public int performAttack() {
        return 10;
    }

    @Override
    public boolean defend(int attackStrength) {

        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 50;
    }

    @Override
    public Yeti clone() {
        return new Yeti();
    }
}


