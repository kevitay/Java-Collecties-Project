package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.consumable.Consumable;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;

import java.util.ArrayList;
import java.util.List;

/*
 * This beast of a class is mostly just prompts to the player
 * The purpose is to offload that logic from the main Game
 * to a class that is designed to manage the players's collection
 * of stuff
 */
public class CollectieManager {

  //----------------------------------------------------
  // MANAGER STATICS
  //----------------------------------------------------

  // Just a static array of the choices players have for managing
  // their collection
  private static final String[] managementOptions = {
    "Show Collection",
    "Show Consumables",
    "Feed Collectie",
    "Rename Collectie",
    "Set Protector",
    "Exit"
  };

  //----------------------------------------------------
  // MANAGER INSTANCES
  //----------------------------------------------------

  private final Printer printer;
  private final Prompt prompt;
  private final List<Collectie> collection = new ArrayList<>();
  private final List<Consumable> consumables = new ArrayList<>();

  // The protector is the currently selected Collectie used in encounters
  private int currentProtector = 0;

  /*
   * Basic constructor
   */
  public CollectieManager(Printer printer, Prompt prompt) {
    this.printer = printer;
    this.prompt = prompt;
  }

  /*
   * Add a Collectie to the collection
   */
  public void add(Collectie collectieToAdd) {
    collection.add(collectieToAdd);

    printer.print(
      "Would you like to rename your new %s?",
      collectieToAdd.getSpecies());

    if(prompt.getYesNo()) renameCollectie(collection.size() - 1);
  }

  /*
   * Add a consumable to the list
   */
  public void addConsumable(Consumable consumableToAdd) {
    consumables.add(consumableToAdd);
  }

  /*
   * Get the current protector
   */
  public Collectie getProtector() {
    return collection.get(currentProtector);
  }

  /*
   * The main "station" that routes menu options
   */
  public void gotoManagementMenu() {
    printer.print("What would you like to do?");

    // Notice the static array declared above is passed here
    printer.formatAsList(managementOptions).print();

    // Get the players initial choice, clamped (restricted)
    // to between 1 and the length of the choices array
    int action = prompt.getChoice(managementOptions.length);

    // If the last option was chosen, return (exit should ALWAYS be the last choice)
    // This return means none of the other logic here is executed
    // thus this is a really simple way to "exit" from this menu
    if(action == managementOptions.length) return;

    // If the chosen option is not a "just list the things" option
    // provide some instructions to the player so they know they will
    // get a prompt to select a collectie
    if(action > 2) printer.print("Select one of your collecties:");

    // If the player chose to print their consumables, do that
    // otherwise print the collecties so they can choose one
    if(action == 2) {
      printConsumableChoices();
    } else {
      printCollectieChoices();
    }

    // If the player chose to do something with a collectie
    if(action > 2) {

      // Get their collectie choice and convert it to a list index
      int collectieIndex = prompt.getChoice(collection.size()) - 1;

      switch(action) {
        case 3:
          feedCollectie(collectieIndex);
          break;
        case 4:
          renameCollectie(collectieIndex);
          break;
        case 5:
          currentProtector = collectieIndex;
          printer.print(
            "Protector is now %s.\n",
            getProtector().getName());
      }
    }

    // Recursively call this menu until the player chooses to exit
    gotoManagementMenu();
  }

  /*
   * Convenience method that prints (and numbers)
   * all the collecties in the collection
   */
  private void printCollectieChoices() {
    for(int i = 0; i < collection.size(); i++) {
      Collectie c = collection.get(i);

      printer.print("Collectie Collection");
      printer.print(
        "[%d] %s (%s)",
        i + 1,
        c.getName(),
        c.getSpecies());
    }
  }

  /*
   * Convenience method the prints all consumables in the list
   * This is uses streams and "method reference" notation to
   * streamline the logic
   * this "streams" the consumable names into an array then
   * passes that array to Prompt.printChoices() thus printing
   * the choices
   */
  private void printConsumableChoices() {
    printer.formatAsList(
      consumables
        .stream()
        .map(Consumable::getName)
        .toArray(String[]::new)
    )
    .print();
  }

  /*
   * Exactly as advertised. Get the Collectie,
   * prompt for a new name, confirm that name,
   * then finally set the new name
   */
  private void renameCollectie(int index) {
    Collectie collectieToRename = collection.get(index);

    printer.print(
      "Renaming %s named %s...",
      collectieToRename.getSpecies(),
      collectieToRename.getName());

    String newName = prompt.getString();

    printer.multiline(
      "You have chosen the name: %s",
      "Confirm rename?"
    )
    .print(newName);

    if(prompt.getYesNo()) {
      collectieToRename.setName(newName);
    } else {
      // If the name given is not confirmed
      // recursively call rename until it is confirmed
      renameCollectie(index);
    }
  }

  /*
   * This method is simpler than it looks
   * All this does it prompts for a consumable choice
   * then calls consumable.consume() and prints different
   * messages based on whether the consumable was finished
   */
  private void feedCollectie(int index) {
    Collectie collectieToFeed = collection.get(index);

    if(consumables.size() == 0) {
      printer.print(
        "You have no consumables to feed %s!",
        collectieToFeed.getName());

      return;
    }

    printer.print(
      "Choose a consumable to give to %s:",
      collectieToFeed.getName());

    printConsumableChoices();

    int consumableIndex = prompt.getChoice(consumables.size()) - 1;
    Consumable consumable = consumables.get(consumableIndex);

    printer.print(
      "You give %s the %s",
      collectieToFeed.getName(),
      consumable.getName());

    //Prompt.fakeWait(3);

    // Consumable.consume() returns true if the it was finished on that call
    if(consumable.consume()) {
      printer.multiline(
        "Looks like %s consumed all of the %s.",
        "It has been removed from your consumables list."
      )
      .print(
        collectieToFeed.getName(),
        consumable.getName()
      );

      consumables.remove(consumable);
    } else {
      printer.multiline(
        "%s could not finish all of the %s.",
        "There is some left over for later."
      )
      .print(
        collectieToFeed.getName(),
        consumable.getName()
      );
    }
  }
}
