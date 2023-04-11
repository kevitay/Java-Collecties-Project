package com.galvanize.collecties.collectie.species;
package com.galvanize.collecties.consumable;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class BoogieWoogie extends Collectie {
    public BoogieWoogie() {
        super(CollectieType.GHOST, "whoo-oo-oo-oo");
    }

    @Override
    public String getGraphic() {
        return " .-.\n" +
                "(o o) boo!\n" +
                "| O \\\n" +
                " \\   \\\n" +
                "  `~~~'";
    }

    @Override
    public Biome getPreferredBiome() {
        return Biome.MOUNTAIN_RANGE;
    }

    @Override
    public int performAttack() {
        return 7;
    }

    @Override
    public boolean defend(int attackStrength) {
        if(Game.TEST_MODE) return false;
        return Game.randogen.nextInt(100) > 10;
    }

    @Override
    public BoogieWoogie clone()  {
        return new BoogieWoogie();
    }
}
