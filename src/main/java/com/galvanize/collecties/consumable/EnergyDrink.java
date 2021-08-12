package com.galvanize.collecties.consumable;

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
}
