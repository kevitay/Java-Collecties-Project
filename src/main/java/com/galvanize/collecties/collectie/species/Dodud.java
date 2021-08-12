package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;

public class Dodud extends Collectie {

  public Dodud() {
    super(CollectieType.SPECIAL, "doooooo-up");
  }

  @Override
  public String getGraphic() {
    return "\\|/          (__)    \n" +
      "     `\\------(oo)\n" +
      "       ||    (__)\n" +
      "       ||w--||     \\|/\n" +
      "   \\|/";
  }

  @Override
  public Biome getPreferredBiome() {
    return Biome.PLAINS;
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
  public Dodud clone() {
    return new Dodud();
  }
}
