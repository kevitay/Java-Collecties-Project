package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Stanley extends Collectie {
    public Stanley() {
        super(CollectieType.SPECIAL, "You know, I learned something today");
    }

    @Override
    public String getGraphic() {
        return "           .-\"\"-.\n" +
                "          _.->    <-._\n" +
                "       .-\"   '-__-'   \"-.\n" +
                "     ,\"                  \",\n" +
                "   .'                      ',\n" +
                "  /    ___...------...___    \\\n" +
                " /_.-*\"__...--------...__\"*-._\\\n" +
                ":_.-*\"'  .*\"*-.  .-*\"*.  '\"*-._;\n" +
                ";       /      ;:      \\       :\n" +
                ";      ;    *  !!  *    :      :\n" +
                ":      :     .'  '.     ;      ;\n" +
                " \\      '-.-'      '-.-'      /\n" +
                "  \\                          /\n" +
                "   '.                      .'\n" +
                "     *,      '-__-'      ,*\n" +
                "     /.'-_            _-'.'\\\n" +
                "    /  \"-_\"*-.____.-*\"_-\"   \\\n" +
                "   /      '\"*-.___.-*'       \\\n" +
                "  :    :        |        ;    ;\n" +
                "  |.--.;       *|        :.--.|\n" +
                "  (   ()        |        ()   )\n" +
                "   '--^_       *|        _^--'\n" +
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
