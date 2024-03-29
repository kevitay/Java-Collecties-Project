package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Pheonexiumalfire extends Collectie {
    public Pheonexiumalfire() {
        super(CollectieType.FIRE, "skadoosh");
    }

    @Override
    public String getGraphic() {
        return "      __             __\n" +
                "   .-'.'     .-.     '.'-.\n" +
                " .'.((      ( ^ `>     )).'.\n" +
                "/`'- \\'._____\\ (_____.'/ -'`\\\n" +
                "|-''`.'------' '------'.`''-|\n" +
                "|.-'`.'.'.`/ | | \\`.'.'.`'-.|\n" +
                " \\ .' . /  | | | |  \\ . '. /\n" +
                "  '._. :  _|_| |_|_  : ._.'\n" +
                "     ````` /T\"Y\"T\\ `````\n" +
                "          / | | | \\\n" +
                "   jgs   `'`'`'`'`'`";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.DESERT;
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
    public Collectie clone() {
        return new Pheonexiumalfire();
    }
}
