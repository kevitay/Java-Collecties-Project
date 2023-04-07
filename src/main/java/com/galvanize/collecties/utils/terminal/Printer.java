package com.galvanize.collecties.utils.terminal;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.io.PrintStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/*
 * A bunch of statics to help print text
 * to the console, IE STDOUT
 * The tag format that is supported by the printer
 * is <red></red> or "mutli-tag" tags like
 * <red bold></red bold> to apply multiple colors/text transforms.
 * NOTE: this class uses a third party library, JColor, to
 * color/format text for the terminal
 */
public class Printer {

  /*
   * This is the regular expression used to match tags
   */
  private static final Pattern tagMatcher = Pattern.compile(
    "<([a-z\\s]+)>([^<>]+)</\\1>",
    Pattern.DOTALL | Pattern.CASE_INSENSITIVE);

  /*
   * Some statics used to facilitate < and > being used inside tags.
   * See the format() method in this class for usage examples.
   */
  private static final String lessThanEscape = "<<";
  private static final String greatThanEscape = ">>";
  private static final String greaterThanTag = "__LEFT_CHOMPER__";
  private static final String lessThanTag = "__RIGHT_CHOMPER__";

  /*
   * To prevent running the loop-filled logic to create the ansi attribute arrays
   * used to colorize the content within a tag, this cache is used. It is filled
   * as attribute arrays are created and if the same tag is encountered again,
   * the cached array is used instead of creating a new one.
   */
  private final Map<String, Attribute[]> attributesCache = new HashMap<>();
  private final PrintStream out;

  /*
   * Flag to determine if the buffer should be printed with
   * a newline appended or not.
   */
  private boolean inline = false;

  /*
   * Flag to determine is thread.sleep() should be use
   * in the wait method, or if the wait method should
   * bypass sleeps and return immediately
   */
  private boolean useSleepForWait = true;

  /*
   * The buffer is used to facilitate chaining
   * some method to make using the printer cleaner.
   */
  private String buffer = "";

  public Printer() {
    this(System.out);
  }
  public Printer(PrintStream printStream) {
    this.out = printStream;
  }

  public String getBuffer() {
    return buffer;
  }

  /*
   * This beast finds all the tags in a string and replaces
   * them with terminal-supported colorized/formatted text
   */
  private String colorize(String stringToColorize) {

    // Copy the input string so we don't mutate it
    String colorizedString = stringToColorize;

    // Loop over anything that is a tag, IE <tag></tag>
    Matcher matcher = tagMatcher.matcher(stringToColorize);
    while(matcher.find()) {

      // The tag name(s), Ex "red bold" in <red bold>
      String tag = matcher.group(1);

      // The array of ansi attributes to apply to the text
      Attribute[] attributesToApply;

      // if there is no cache for this tag
      if(!attributesCache.containsKey(tag)) {

        // This will be build up based on the tag names
        // found within the matched tag
        // Ex: this will be ["red","bold"] if the tag is <red bold>
        List<Attribute> attributesList = new ArrayList<>();

        // Placeholder for the TagMatcher
        // enum we will try to get
        AnsiAttributes matchedTag;

        // Split the tag name(s) on whitespace characters
        // And loop over each name
        for(String a : tag.split("\\s")) {
          try {

            // Get the tag enum based on the tag name
            // This will throw an exception if there is no
            // enum element for the text given
            matchedTag = AnsiAttributes.valueOf(a.toUpperCase());

            // Get the ansi attribute from the enum found
            attributesList.add(matchedTag.getAnsiAttribute());

          } catch (Exception e) {
            // just ignore any tags that not listed in the enum
          }
        }

        // Convert the list to an array and add it to the cache
        attributesToApply = attributesList.toArray(Attribute[]::new);
        attributesCache.put(tag, attributesToApply);
      } else {

        // If the cache has the tag, use the cache
        attributesToApply = attributesCache.get(tag);
      }

      // Replace the tag group with the colorized/formatted
      // version of the tag's content
      colorizedString = colorizedString.replaceFirst(
        Pattern.quote(matcher.group()), // This returns the whole matched "group", IE <red>red text</red>
        Ansi.colorize(
          Matcher.quoteReplacement(matcher.group(2)), // This is just the tag content, IE the "innerText"
          attributesToApply));
    }

    return colorizedString;
  }

  /*
   * Takes in a bunch of strings as separate arguments
   * and joins them with a newline
   */
  public Printer multiline(String ...strings) {
    buffer = String.join("%n", strings);
    return this;
  }

  /*
   * Chainable switch that sets inline printing to
   * true.
   */
  public Printer inline() {
    inline = true;
    return this;
  }

  /*
   * Main formatting method. It supports both color tagging
   * and "%" replacement formatting. Just give it a string and
   * any replacement values, and it will return a formatted string.
   */
  public Printer format(String stringToFormat, Object ...replacements) {

    // Replace bracket escapes with a placeholder tag
    String input = stringToFormat.replaceAll(lessThanEscape, lessThanTag);
    input = input.replaceAll(greatThanEscape, greaterThanTag);

    // Do the replacements and tag-based coloring and formatting
    String formattedString = String.format(input, replacements);
    formattedString = colorize(formattedString);

    // Replace the bracket placeholders with actual brackets
    formattedString = formattedString.replaceAll(lessThanTag, "<");
    formattedString = formattedString.replaceAll(greaterThanTag, ">");

    this.buffer = formattedString;
    return this;
  }

  /*
   * Takes in an array of strings and formats them as a list in the format
   * "[#] Text". Supports both color/formatting tags and % replacements in
   * the strings given in the array.
   */
  public Printer formatAsList(String[] options, Object ...replacements) {
    List<String> numberedOptions =  new ArrayList<>();
    for(int o = 0; o < options.length; o++) {
      numberedOptions.add(
        String.format("[%d] %s", o + 1, options[o]));
    }

    format(
      multiline(numberedOptions.toArray(String[]::new)).getBuffer(),
      replacements);

    return this;
  }

  /*
   * Main print method. Supports both color/formatting tags and % replacements
   * in the string given.
   * Due to how the ...args syntax works, to support buffer printing with multiple
   * arguments we have to combine stringToPrint with replaces when making the
   * subsequent print call with the buffered text.
   */
  public void print(String stringToPrint, Object ...replacements) {
    if(buffer.length() > 0) {
      String bufferCopy = buffer;
      buffer = ""; // Clear the buffer after copying it

      // Print the string from the buffer
      print(bufferCopy,
        Stream.concat( // combine stringToPrint with other replacements
          Stream.of( stringToPrint ),
          Arrays.stream( replacements ))
          .toArray());
      return;
    }

    if(!inline) {
      out.println(
        format(stringToPrint, replacements)
          .getBuffer());
    } else {
      out.print(
        format(stringToPrint, replacements)
          .getBuffer());

      inline = false;
    }

    // Clear the buffer after printing
    buffer = "";
  }

  /*
   * A single argument print for the use case of
   * printing the buffer with a single % replacement
   * but the replacement is an object.
   */
  public void print(Object replacement) {
    print(replacement.toString(), "");
  }

  /*
   * Print method that can be called to print the buffer without replacements.
   */
  public void print() {
    print(new Object());
  }

  /*
   * Simulates loading or processing by
   * printing "."s at one second intervals
   */
  public void wait(Integer seconds, String text) {
    inline().print(text);

    // If test mode is enabled, we force an instant completion
    if(!this.useSleepForWait) {
      print(".".repeat(seconds));
      return;
    }

    // End the loop at current time + X seconds
    long t = System.currentTimeMillis();
    long end = t + (seconds.longValue() * 1000);

    // Every second (till end) print "."
    while(System.currentTimeMillis() < end) {
      try {
        inline().print(".");

        // You should NEVER use sleep or pause in a real application
        // We are just having fun so we can be a little crazy
        Thread.sleep( 1000);
      } catch (Exception e) {
        System.err.println(e.getMessage());
        break;
      }
    }

    print("");
  }
  /*
   * Buffer-based wait
   */
  public void wait(int seconds) {
    wait(seconds, getBuffer());
  }

  /*
   * Used to force the wait method to return immediately,
   * bypassing the thread.sleep loop used to fake processing time
   */
  public void disableSleep() {
    this.useSleepForWait = false;
  }
}
