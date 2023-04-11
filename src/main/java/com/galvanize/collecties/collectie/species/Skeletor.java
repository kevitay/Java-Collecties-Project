package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Skeletor extends Collectie {


    public Skeletor() {
        super(CollectieType.ELEMENTAL, "Got Milk?");
    }

    @Override
    public String getGraphic() {
        return "                              _.--\"\"-._\n" +
                "  .                         .\"         \".\n" +
                " / \\    ,^.         /(     Y             |      )\\\n" +
                "/   `---. |--'\\    (  \\__..'--   -   -- -'\"\"-.-'  )\n" +
                "|        :|    `>   '.     l_..-------.._l      .'\n" +
                "|      __l;__ .'      \"-.__.||_.-'v'-._||`\"----\"\n" +
                " \\  .-' | |  `              l._       _.'\n" +
                "  \\/    | |                   l`^^'^^'j\n" +
                "        | |                _   \\_____/     _\n" +
                "        j |               l `--__)-'(__.--' |\n" +
                "        | |               | /`---``-----'\"1 |  ,-----.\n" +
                "        | |               )/  `--' '---'   \\'-'  ___  `-.\n" +
                "        | |              //  `-'  '`----'  /  ,-'   I`.  \\\n" +
                "      _ L |_            //  `-.-.'`-----' /  /  |   |  `. \\\n" +
                "     '._' / \\         _/(   `/   )- ---' ;  /__.J   L.__.\\ :\n" +
                "      `._;/7(-.......'  /        ) (     |  |            | |\n" +
                "      `._;l _'--------_/        )-'/     :  |___.    _._./ ;\n" +
                "        | |                 .__ )-'\\  __  \\  \\  I   1   / /\n" +
                "        `-'                /   `-\\-(-'   \\ \\  `.|   | ,' /\n" +
                "                           \\__  `-'    __/  `-. `---'',-'\n" +
                "                              )-._.-- (        `-----'\n" +
                "                             )(  l\\ o ('..-.\n" +
                "                       _..--' _'-' '--'.-. |\n" +
                "                __,,-'' _,,-''            \\ \\\n" +
                "               f'. _,,-'                   \\ \\\n" +
                "              ()--  |                       \\ \\\n" +
                "                \\.  |                       /  \\\n" +
                "                  \\ \\                      |._  |\n" +
                "                   \\ \\                     |  ()|\n" +
                "                    \\ \\                     \\  /\n" +
                "                     ) `-.                   | |\n" +
                "                    // .__)                  | |\n" +
                "                 _.//7'                      | |\n" +
                "               '---'                         j_| `\n" +
                "                                            (| |\n" +
                "                                             |  \\\n" +
                "                                             |lllj\n" +
                "                                             ||||| ";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.DESERT;
    }

    @Override
    public int performAttack() {
        return 3;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 70;
    }

    @Override
    public Skeletor clone() {
        return new Skeletor();
        }
    }

