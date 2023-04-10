package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Game;

/*
 * This enum is used as a master list for all consumables
 * If the consumable is not set up here it will not be obtainable
 * during gameplay
 * Tracking consumable types this way is a bit cleaner than
 * alternatives for aggregating a list of all consumables
 * Basically creating a static map for all consumables here
 */
public enum Consumables {

  // Each element in this enum requires
  // a reference instance of the class
  // it represents
  // CONSUMABLE(new Consumable()) / KEY(VALUE)
  QUESTIONABLE_MUSHROOM(new QuestionableMushroom()),
  ENERGY_DRINK(new EnergyDrink()),
  PIZZA(new Pizza()),
  PHOENIXWING(new PhoenixWing()),
  NIBBLETS(new Nibblets());

  // Create a static array of all the Consumables
  private static final Consumables[] consumablesArray = Consumables.values();

  /*
   * Use the consumables array to easily get a random consumable
   */
  public static Consumable getRandomConsumable() {
    return consumablesArray[Game.randogen.nextInt(consumablesArray.length)]
      .getReference()
      .clone();
  }

  /*
   * Enums can actually have a constructor
   * and instance data/methods. In this case
   * we just need to keep a reference object
   * for the consumable each enum represents
   * This allows us to easy create clones of
   * those reference objects attached to each enum
   * Basically we are creating a static list for all
   * consumables
   */

  private final Consumable reference;

  Consumables(Consumable reference) {
    this.reference = reference;
  }

  public Consumable getReference() {
    return reference;
  }
}
