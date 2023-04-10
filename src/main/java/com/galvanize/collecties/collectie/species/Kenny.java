package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;


public class Kenny extends Collectie {

    public Kenny() {super (CollectieType.SPECIAL,  "Woo-Hoo!"); }


    @Override
    public String getGraphic() {

        return "  _.-*'\"\"'*-._\n" +
                "       .-\"            \"-.\n" +
                "     ,\"                  \",\n" +
                "   .'      _.-.--.-._      ',\n" +
                "  /     .-'.-\"    \"-.'-.     \\\n" +
                " /     /  /\"'-.  .-'\"\\  \\     \\\n" +
                ":     :  :     ;:     ;  ;     ;\n" +
                ";     :  ; *   !! *   :  ;     :\n" +
                ";      ; :   .'  '.   ; :      :\n" +
                ":       \\ \\-'      '-/ /       ;\n" +
                " \\       '.'-_    _-'.'       /\n" +
                "  \\        '*-\"-+\"-*'        /\n" +
                "   '.          /|          .'\n" +
                "     *,       / |        ,*\n" +
                "     / '-_            _-'  \\\n" +
                "    /     \"*-.____.-*\"      \\\n" +
                "   /            |            \\\n" +
                "  :    :        |        ;    ;\n" +
                "  |.--.;        |        :.--.|\n" +
                "  (   ()        |        ()   )\n" +
                "   '--^_        |        _^--'\n" +
                "      | \"'*--.._I_..--*'\" |\n" +
                "      | __..._  | _..._   |\n" +
                "     .'\"      `\"'\"     ''\"'.\n" +
                "     \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"";
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
