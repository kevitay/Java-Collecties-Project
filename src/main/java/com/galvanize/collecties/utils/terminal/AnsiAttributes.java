package com.galvanize.collecties.utils.terminal;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Attribute.*;

/*
 * This enum holds ansi attributes that can be used
 * to color or format text in the terminal. This enum
 * is mainly meant to simplify logic in the project but
 * these can be used with the JColor colorize method anywhere.
 * Note: This enum utilizes an external library
 * called JColor to provide the ansi attributes
 * needed to colorize/format the text in the terminal
 */
public enum AnsiAttributes {
  // Formatting
  BOLD((BOLD())),
  UNDERLINE(UNDERLINE()),
  ITALIC(ITALIC()),
  STRIKE(STRIKETHROUGH()),

  // Regular Colors
  WHITE(BRIGHT_WHITE_TEXT()),
  GREY(WHITE_TEXT()),
  DARKGREY(BRIGHT_BLACK_TEXT()),
  BLACK(BLACK_TEXT()),
  RED(RED_TEXT()),
  BLUE(BLUE_TEXT()),
  GREEN(GREEN_TEXT()),
  CYAN(CYAN_TEXT()),
  MAGENTA(MAGENTA_TEXT()),
  YELLOW(YELLOW_TEXT());

  // Each enum represents a single ansi attribute
  private final Attribute ansiAttribute;

  /*
   * Basic constructor
   * just set the ansi attribute field
   */
  AnsiAttributes(Attribute ansiAttribute) {
    this.ansiAttribute = ansiAttribute;
  }

  public Attribute getAnsiAttribute() {
    return ansiAttribute;
  }
}
