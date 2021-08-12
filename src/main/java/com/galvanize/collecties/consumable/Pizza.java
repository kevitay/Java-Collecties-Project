package com.galvanize.collecties.consumable;

public class Pizza implements Consumable {

  private int slices = 4;

  @Override
  public String getName() {
    return String.format(
      "Small Pizza with Dodud Sausage (%d)",
      slices);
  }

  @Override
  public boolean consume() {
    if(slices == 0) return true;

    slices--;
    return slices == 0;
  }

  @Override
  public Consumable clone() {
    return new Pizza();
  }
}
