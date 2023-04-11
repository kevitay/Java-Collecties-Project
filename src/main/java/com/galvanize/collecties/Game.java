package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.species.Rextore;
import com.galvanize.collecties.consumable.Consumable;
import com.galvanize.collecties.consumable.Consumables;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;

import java.util.Random;
import java.util.Scanner;


/*
 * Quite literally the "main" class.
 */
public class Game {

  //----------------------------------------------------
  // GAME STATICS
  //----------------------------------------------------

  /*
   * A convenience flag that can be used throughout the
   * project to provide test-only logic
   * see Prompt.fakeWait() for a good example of usage
   */
  public static final boolean TEST_MODE = false;

  /*
   * Making the random generator a static allows us to create a single
   * generator for the whole project that we can reference anywhere
   * See Collectie.getRandomCollectieForBiome() for an example
   */
  public static Random randogen = new Random();

  /*
   * No reason to create our menu choices for
   * every instance of the Game class
   */
  public static String[] mainMenuChoices = {
    "Travel to the next Biome",
    "Explore",
    "Manage Collection",
    "Exit"
  };
  private boolean exitGame;

  // MAIN METHOD!
  public static void main(String[] args) {
    Printer printer = new Printer();
    Scanner scanner = new Scanner(System.in);
    Prompt prompter = new Prompt(scanner, printer);

    Game game = new Game(printer, prompter);
    game.start();
  }

  //----------------------------------------------------
  // GAME INSTANCES
  //----------------------------------------------------

  // Each Game instance should have its own printer
  // for easier testing
  Printer printer;

  // Each Game instance should have its own prompt instance
  // for easier testing
  Prompt prompt;

  // Initialize the inventory manager instance
  // It has a dependency of a prompt
  CollectieManager collection;

  // Start with a random biome
  Biome currentBiome = Collectie.getRandomNonEmptyBiome();

  Game(Printer printer, Prompt prompt) {
    this.printer = printer;
    this.prompt = prompt;
    this.collection = new CollectieManager(printer, prompt);
  }

  /*
   * It is always good to have an explicit start method
   * as opposed to doing a whole bunch in a constructor
   * If it is more than just setting up fields, you might
   * want to take this approach
   */
  public void start() {
    printer.multiline(
      "", // Just add some space in the terminal before
      "", // starting the game
      "*------------------------------------------*",
      "<bold>| Welcome to the </bold>" +
      "<bold yellow>wild</bold yellow><bold green> world </bold green>" +
      "<bold>of Collecties! |</bold>",
      "*------------------------------------------*"
    )
    .print();

    Collectie starter = new Rextore();

    printer.print(
      "To start your collection you were given a <bold>%s</bold>!",
      starter.getSpecies());

    collection.add(starter);

    gotoMainMenu();
  }

  /*
   * This is basically the main router of the game
   * From here a player can do anything the game offers
   * even if that is just passing them to another menu
   */
  private void gotoMainMenu() {
    printer.multiline(
      "You find yourself in a <bold>%s</bold> biome.",
      "What would you like to do?"
    )
    .print(currentBiome);

    // Notice we are passing our static array of options defined above
    printer.formatAsList(mainMenuChoices).print();

    switch(prompt.getChoice(mainMenuChoices.length)) {
      // All we do here is do a fake "loading" then pick a new random biome
      case 1:
        printer.wait(3,"Traveling");
        currentBiome = Collectie.getRandomNonEmptyBiome();
        gotoMainMenu();
        break;

      case 2:
        printer.format(
          "Exploring the %s biome around you.",
          currentBiome)
        .wait(5);

        // 50% chance to find something vs having an encounter
        // Offload both to a another method to avoid a bunch of
        // logic here
        if(randogen.nextInt(100) > 50) {
          findConsumable();
        } else {
          enounter();
        }
        break;

      case 3: // We offload inventory management to a different class
        collection.gotoManagementMenu();
        break;

      // Since prompt.getChoice() clamps it's return
      // we will only ever hit the default if 4 is selected
      // but it is still good to have this be a backup
      // just in case we EVER get an unexpected input somehow
      default:
        this.exitGame = true;
        printer.print("Thank you for playing!");

        // This literally ends the execution of the program
        // Anything other than 0 would be a non-OK exit
        break;
//        System.exit(0);
    }

    // Recursive loop of the method so you get the menu
    // after every event until you exit this main menu
    if(!exitGame)
      gotoMainMenu();
  }

  /*
   * Most of the encounter logic is offloaded to another class
   * Head over to that class for more information
   */
  private void enounter() {
    Encounter encounter = new Encounter(
      printer, prompt,
      collection.getProtector(),
      currentBiome);

    // encounter.start() returns true if the player wants
    // to keep the Collecite they defeated
    if(encounter.start()) {
      Collectie newCollectie = encounter.getOpponent();
      collection.add(newCollectie);
    }
  }

  /*
   * Get a random consumable and add it to the inventory
   */
  private void findConsumable() {
//    Consumable foundConsumable = Consumables.getRandomConsumable();

//    collection.addConsumable(foundConsumable);
//
//    printer.multiline(
//      "You found a %s while exploring.",
//      "It has been added to your consumables."
//    )
//    .print(foundConsumable.getName());
  }
}
