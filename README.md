# Collecties! ______ Edition

Welcome to the world of collecties, where you explore and collect little animals called Collecties. As a developer and creative working on this project your job is to add _at least_ one new Collectie and _at least_ one new consumable item to the world. Follow the steps outlined below to do so.

## Getting Started

Simply clone this repository and make a branch. This project follows a Pull Request workflow so make sure you are **ALWAYS** working on a branch.

## Adding a Collectie

1. Start by creating a test class for your new species under `org.collectiespink.collectie.species` under the test root.
2. Use the existing species tests as a guide to create your test suite, and by extension, your new species. Keep in the mind the following as you work on your species:
    * You species class (not your test class) will go in `org.collectiespink.collectie.species` under the source root.
    * Your class should `extend Collectie`, the abstract base class of all species. This ensures your species has all the methods it needs.
    * Your constructor should **NEVER** take any arguments. The application will not work with your species otherwise.
    * Make sure you test and implement **ALL** the required methods, including clone. The example test suites can help as a double check.
3. Once you feel your tests and species is complete, you have to add your species to the master list for it to be available during gameplay. To do this:
    1. open the `CollectieSpecies` enum under `org.collectiespink.collectie.species`.
    2. Use the current entries and comments to guide you through adding your species to the enum. You will be adding **ONE LINE** to this file.
4. With your species tested and added to the master list, you should be able to run the game and have it show up in the wild!

## Adding a Consumable

Follow the same steps outlined for adding a new collectie species, with the following differences:

* Consumables are part of the `org.collectiespink.consumable` package, both under the source and test root.
* Instead of extending `Collectie`, your consumable needs to `implement consumable`, which is an interface.
* The master list of consumables is the `Consumables` enum found under `org.collectiespink.consumable`. You will be adding **ONE LINE** to this file.

## Advanced Tickets

When you are satisfied with the collecties and consumables you have added to the project, you have the option to improve the project more fundamentally. Below are some improvements you can attempt to make once you are ready.

**IMPORTANT**: Make your intention known to the class before you get started. You are required to join any existing effort if there is already work being done for the specific improvement you want to work on. A simple "is anyone working on X" type message allows you to meet up with anyone working on that improvement.

If you work on any of these, make sure you continuously keep in mind code organization and quality. Don't just a bunch of logic into a method and call it done. Think about creating new methods or adding class fields if needed. Some of these improvements will undoubtedly change the structure of a class.

### Attack on Run
1. In the `Encounter` logic, add in a chance (50%? 75%? up to you) that the opponent will get an "attack of opportunity" when the player runs from an encounter.

### Knocked-Out Status
1. Create a new enum called `CollectieStatus` inside the `org.collectiespink.collectie` package. There should be two statuses, one for conscious and one for unconscious. The name of enum elements are up to you, as long as there are two statuses.
2. Once created, add a field to the `Collectie` base class called `status`. The initial value should conscious.
3. Don't forget getters and setters.
4. When a protector is defeated in battle, set their status to unconscious. Hint: this will be done in the `Encounter` class, not the `Game` class.
5. If you attempt to go into battle with an unconscious protector, you should automatically run from the encounter. Again, this logic should go in the `Encouter` class.
6. Create a special consumable that when feed to an unconscious collectie, it revives them. Make sure you add tests for this item.

### Improved Combat
1. Add a new field to the base Collectie class called `hitpoint`, `lifepoints`, `vitality`, or some variation. Name is up to you. Set the initial value to 0 to force species definitions to set the field in their constructor.
2. To the base Collectie class, add two methods, one for checking is this field is 0 (returns a boolean), and one to subtracts from the value then returns the return from the "is 0" method (so the subtract method returns if that subtraction made the field fall below 0). Notice there will be no getter or setter in the traditional sense here. These methods are designed for how code will interact with the field.
3. Refactor the `Encounter` logic so each attack subtracts from this new field and either side is defeated only when this field is 0. The attack/counter-attack style of combat should be kept but outcome should be determined by which collectie reaches 0 first (the loser).
4. You may need to coordinate with the Knock-Out group so that you can incorporate setting the status of the loser to unconscious.

### Collectidex
1. Start by creating a new class called `Collectidex`. This is where the Collectidex logic will go.
    * The constructor should take in a printer and a prompt.
2. Next create a method called `gotoCollectidexMenu()`. This method should utilize the `CollectieSpecies` enum to list all the available species (not the player's collection, but all the SPECIES). It should then prompt the user to select one. Pass the player's selection to the next method.
3. Create a second method called `printCollectieInformation(Collectie collectie)`. It should take in a collectie and print any relevant information you think the player would want to know about it.
4. Back in the menu method, after calling the print method prompt the user to ask if they want to view another collectie. If they do recursively call the menu method, otherwise return the menu method (you shouldn't need to use the return value, you should just be letting the method "end").
5. Finally, in `Game`:
    1. Add a field for a `Collectidex` instance and set it to a new instance in the constructor.
    2. Add a new option to the main menu for "Collectidex". If this option is selected, call `gotoCollectidexMenu()` on the collectidex field.

### Biome Specific Consumables
1. Add a "Biome getContainingBiome()" method signature to the `Consumable` interface (yes, this will force you to add it to each Consumable, but you get to choose Biome for each Consumable). This should return the Biome the consumable can be found in.
2. Update the `getRandomConsumable()` method in the `Consumables` enum to take in a Biome as an argument. Update the logic in this method to pick random Consumables until it finds one for the Biome passed in.
    * HINT: Utilize `enum.getReference()` to gain access to each consumables `getContainingBiome()` method.
3. Also add logic that will check `consumablesArray` before the loop to make sure there is a consumable for the Biome given. If there is no consumable for the Biome, return null.
3. Update the logic in `Game` to pass in the `currentBiome` to `getRandomConsumable()`. Make sure you check if this returns null and give the player feedback if no consumable could be found. Maybe their exploration did go so well or the biome is too desolate to find anything?

### Special Moves
HINT: you may want to do this as class or split the specials you have to create between a couple groups. Don't want to hog the fun of creating specials.
1. Add a `special()` abstract method to the `Collectie` abstract class. (yes this will force you to add a `special()` method to each species)
    * These specials can do whatever you'd like. Maybe they just output text, maybe they give you random consumables, or maybe there is a chance for the collectie to use the special in combat. Whatever you can think up.
2. Add an option both during a skirmish and in the collectie management interface to perform the special.
    * Keep in mind that the special does not take any arguments, so if used it combat it will just be either a heal or a buff of some sort.