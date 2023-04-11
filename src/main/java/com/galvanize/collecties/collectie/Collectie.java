package com.galvanize.collecties.collectie;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.species.CollectieSpecies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * The base Collectie class
 */
public abstract class Collectie {

  //----------------------------------------------------
  // COLLECTIE STATICS
  //----------------------------------------------------

  // Name covers what this is suppsed to be used for
  public static final Map<Biome, List<Collectie>> speciesByBiomeReference = new HashMap<>();

  /*
   * Fills in the species for biomes reference map
   */
  public static void buildSpeciesBiomeMap() {

    // Loop over every biome and add an empty list to the map for it
    for(Biome b : Biome.values()) {
      speciesByBiomeReference.put(b, new ArrayList<>());
    }

    // Loop over every species via the species reference enum
    for(CollectieSpecies s : CollectieSpecies.values()) {

      // the species enum holds a reference instance for each species
      Collectie collectie = s.getReference();

      speciesByBiomeReference
        // Get the list for the biome of the collectie
        .get(collectie.getPreferredBiome())
        // Add a reference clone to that list
        .add(collectie.clone());
    }
  }

  /*
   * This returns a new random collectie instance, but limits the
   * choices to a specific biome using the collectie/biome reference map
   */
  public static Collectie getRandomCollectieForBiome(Biome targetBiome) {

    // If the reference map is empty, build it
    if(speciesByBiomeReference.size() == 0) {
      buildSpeciesBiomeMap();
    }

    // Get the list of collecties for the biome in question
    List<Collectie> collecties = speciesByBiomeReference.get(targetBiome);

    // Pick a random collectie from that list
    return collecties
      .get(Game.randogen.nextInt(collecties.size()))
      .clone();
  }

  /*
   * Gets a random biome but limits the return to a biome
   * that has collecties that prefer it
   * This is added to Collectie instead of Game because
   * this class is where the collectie to biome reference is
   */
  public static Biome getRandomNonEmptyBiome() {

    // If the reference map is empty, build it
    if(speciesByBiomeReference.size() == 0) {
      buildSpeciesBiomeMap();
    }

    // Loop until a biome that has collectie species for it is found
    // this works as long as their is one collectie species defined
    // so technically this could turn infinite if no species are defined
    Biome biome = Biome.getRandomBiome();
    while(speciesByBiomeReference.get(biome).size() == 0) {
      biome = Biome.getRandomBiome();
    }

    return biome;
  }

  //----------------------------------------------------
  // COLLECTIE INSTANCES
  //----------------------------------------------------

  // CollectieType is an enum
  // Head over to that file for more information
  private final CollectieType type;
  private String name;
  private final String sound;
  private CollectieStatus collectieStatus = CollectieStatus.CONSCIOUS;

  /*
   * Basic constructor except all Collecties start with a
   * random name
   */
  public Collectie(CollectieType type, String sound) {
    this.name = this.getSpecies() + " " + Game.randogen.nextInt();
    this.type = type;
    this.sound = sound;
  }

  public CollectieStatus getCollectieStatus() {
    return this.collectieStatus;
  }

  /*
   * Use the class name as the species name
   * this works with subclasses even though
   * it is defined on the parent class
   */
  public String getSpecies() {
    return this.getClass().getSimpleName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CollectieType getType() {
    return type;
  }

  // Collecties always SCREAM their sound
  // ...always
  public String speak() {
    return sound.toUpperCase();
  }

  /*
   * Abstract classes allow you to define abstract methods
   * which are method signatures that are required to be
   * overridden by child classes but have no implementations
   * in the abstract class itself, just like interfaces
   */

  // This will be printed at the introduction of an encounter
  public abstract String getGraphic();

  // Used to determine what biomes they can found in
  public abstract Biome getPreferredBiome();

  // Notice this returns an int, IE "attack power"
  public abstract int performAttack();

  // Notice this returns a boolean, IE "was the defense successful?"
  public abstract boolean defend(int attackStrength);

  // Clone should be used to return a new instance of the child class
  // IE myRextore.clone() != myRextore and rexClone is a Rextore instance
  public abstract Collectie clone();
}
