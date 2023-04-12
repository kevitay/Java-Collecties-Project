package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class EnergyDrink implements Consumable {
  @Override
  public String getName() {
    return "Rextore Claws Energy Drink";
  }

  @Override
  public boolean consume() {
    return true;
  }

  @Override
  public Consumable clone() {
    return new EnergyDrink();
  }

  @Override
  public Biome getContainingBiome() {
    return Biome.TUNDRA;
  }
}
