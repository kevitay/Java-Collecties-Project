package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;

import java.util.ArrayList;
import java.util.List;

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
  COFFEE_DRINK(new CoffeeDrink()),
  KONA_COFFEE(new KonaCoffee()),

  VEGAN_HOTDOGS(new VeganHotdogs()),

  ANABOLICSTEROIDS(new AnabolicSteroids()),
  PHOENIXWING(new PhoenixWing()),
  NIBBLETS(new Nibblets()),
  BANANAS(new Bananas()),
  SPINACH(new Spinach()),
  FROZEN_WAFFLE (new FrozenWaffle()),
  SUGAR_CUBE(new SugarCube()),
  PROTEIN(new Protein()),
  MILK(new Milk()),
  FINGERFOOD(new FingerFood()),
  TRUBLOOD(new TruBlood()),
  DINGHY (new Dinghy()),
  CHEESYPOOFS (new CheesyPoofs());


  // Create a static array of all the Consumables
  private static final Consumables[] consumablesArray = Consumables.values();

  /*
   * Use the consumables array to easily get a random consumable
   */
  public static Consumable getRandomConsumable(Biome biome) {
    List<Consumable> foundConsumables = new ArrayList<>();
    for (int i = 0; i < consumablesArray.length; i++) {
      if(biome.equals(consumablesArray[i].getReference().getContainingBiome())){
        foundConsumables.add(consumablesArray[i].getReference().clone());
      }
    }
    if(foundConsumables.size() == 0){
      return null;
    } else {
      Consumable randomConsumable = foundConsumables.get(Game.randogen.nextInt(foundConsumables.size()));
//              .getReference()
//              .clone();
      return randomConsumable;
    }
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
