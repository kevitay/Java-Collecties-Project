package com.galvanize.collecties.utils.terminal;


import java.util.Scanner;

/*
 * This class provides helpers for getting user input from
 * the terminal. To fully understand all the logic here you
 * may need to read up on the Scanner class/objects.
 */
public class Prompt {

  // Couple of constant strings that are used standardize the terminal output
  public final static String promptString = "?: ";
  public final static String invalidInputMessage = "Invalid choice. Please try again.";

  // Scanners are used to get input (prompts) from the terminal
  Scanner scanner;

  // To print things
  Printer printer;

  public Prompt(Scanner scanner, Printer printer) {
    this.scanner = scanner;
    this.printer = printer;
  }

  /*
   * This is used to dump extra lines which
   * can happen with some of getting specific
   * inputs with the scanner
   */
  private void dump() {
    if(scanner.hasNextLine()) {
      scanner.nextLine();
    }
  }

  /*
   * Gets an int from the player via a prompt
   * It clamps (restricts) the int between 1 and maxChoice
   */
  public int getChoice(int maxChoice) {
    printer.inline().print(promptString);

    if(scanner.hasNextInt()) {
      int choice = scanner.nextInt();

      if(choice < 1 || choice > maxChoice) {
        printer.print(invalidInputMessage);
      } else {
        dump();
        return choice;
      }
    } else {
      dump();
      printer.print(invalidInputMessage);
    }

    // Recursively let the player try to input again
    return getChoice(maxChoice);
  }

  /*
   * Just get whatever the heck the player inputs into the prompt
   */
  public String getString() {
    printer.inline().print(promptString);

    if(scanner.hasNextLine()) {
      String text = scanner.nextLine();
      return text;
    }

    return "";
  }

  /*
   * Like getString() but clamps the accepted input to
   * yes(y) or no(n) then returns true for yes and false for no
   */
  public boolean getYesNo() {
    printer.inline().print("[y/n]");

    switch (getString().toLowerCase()) {
      case "y":
      case "yes":
        return true;
      case "n":
      case "no":
        return false;
      default:
         printer.print(invalidInputMessage);
        return getYesNo();
    }
  }
}
