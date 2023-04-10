package com.galvanize.collecties.consumable;

public class PhoenixWing implements Consumable {

  private int bites = 3;

  @Override
  public String getName() {
    return String.format(
      "A fire roasted Phoenix wing (%d)",
      bites);
  }

  @Override
  public boolean consume() {
    if(bites == 0) return true;

    bites--;
    return bites == 0;
  }

  @Override
  public Consumable clone() {
    return new PhoenixWing();
  }
}
