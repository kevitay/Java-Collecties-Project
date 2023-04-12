package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

/*
 * The consumable interface just makes sure all consumables
 * have a name, can be consumed, and can be cloned
 */
public interface Consumable {
  public String getName();
  public boolean consume();
  public Consumable clone();
  public Biome getContainingBiome();
}
