package com.galvanize.collecties.consumable;

/*
 * The consumable interface just makes sure all consumables
 * have a name, can be consumed, and can be cloned
 */
public interface Consumable {
  public String getName();
  public boolean consume();
  public Consumable clone();
}
