package com.galvanize.collecties.utils.terminal;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static com.diogonunes.jcolor.Ansi.colorize;
import static com.diogonunes.jcolor.Attribute.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Printer")
public class PrinterTests {

  /*
   * Sets up System.out to use a controlled byte stream
   * that can be used to capture what is printed using
   * system.out methods.
   */
  public ByteArrayOutputStream setupStandardOut() {
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bs));

    return bs;
  }

  /*
   * Flush the given output stream and return the text
   * written to it.
   */
  public String flushOutputStream(ByteArrayOutputStream bs) {
    try {
      bs.flush();
    } catch (IOException e) {
      System.err.println(e.getMessage());
      return "";
    }

    return bs.toString();
  }

  Printer printer;

  @BeforeEach
  public void setupTest() {
    printer = new Printer();
  }

  @Test
  public void multilineShouldChain() {
    Printer printerRef = printer.multiline("");
    assertEquals(printerRef, printer);
  }

  @Test
  public void multilineShouldJoinStringsWithANewline() {
    String line1 = "First line";
    String line2 = "Second Line";

    assertEquals(
      line1 + "%n" + line2,
      printer.multiline(line1, line2).getBuffer());
  }

  @Test
  public void formatShouldNotExplodeIfGivenARegularString() {
    assertDoesNotThrow(
      () -> printer.format("Nothing Special"));
  }

  @Test
  public void formatShouldBeChainable() {
    String testString = "Test String!";

    assertEquals(
      testString,
      printer.format(testString).getBuffer()
    );
  }

  @Test
  public void formatShouldAllowForReplacements() {
    String replacement = "REPLACED";
    String targetString = "This was %s!";
    String expectedString = "This was " + replacement + "!";

    assertEquals(
      expectedString,
      printer.format(targetString, replacement).getBuffer());
  }

  @Test
  public void formatShouldProcessColorTags() {
    String testText = "Red Text";
    String taggedText = "<red>" + testText + "</red>";

    assertEquals(
      colorize(testText, RED_TEXT()),
      printer.format(taggedText).getBuffer()
    );
  }

  @Test
  public void bigOlFormatTestWithNestedTags() {
    String replacement = "REPLACED!";

    String expected = "This is ";
    expected += colorize("a big string", BOLD());
    expected += " with ";
    expected += colorize( "%s", BOLD());
    expected +=  " text and ";
    expected += colorize("multi-formatted text", BOLD(), BLUE_TEXT());

    String stringToFormat = "This is ";
    stringToFormat += "<bold>a big string</bold>";
    stringToFormat += " with <bold>%s</bold> text and ";
    stringToFormat += "<bold blue>multi-formatted text</bold blue>";

    assertEquals(
      String.format(expected, replacement),
      printer
        .format(stringToFormat, replacement)
        .getBuffer());
  }

  @Test void listFormatShouldBeChainable() {
    String[] testList = {"one","two"};
    String expected = "[1] " + testList[0] + "%n" +
      "[2] " + testList[1] + "%n";

    ByteArrayOutputStream bs = setupStandardOut();

    printer.formatAsList(testList).print();

    String printed = flushOutputStream(bs);
    assertEquals(String.format(expected), printed);
  }

  @Test
  public void shouldBeAbleToPrintAListOfOptions() {
    String replacement = "NOW!";
    String[] listToFormat = {
      "Travel to the next <green>Biome</green>",
      "Explore",
      "Manage <bold>Collection</bold>",
      "Exit %s"
    };

    String expected = "[1] Travel to the next ";
    expected += colorize("Biome", GREEN_TEXT());
    expected += "%n[2] Explore%n[3] Manage ";
    expected += colorize("Collection", BOLD());
    expected += "%n[4] Exit NOW!";

    assertEquals(
      String.format(expected),
      printer
        .formatAsList(listToFormat, replacement)
        .getBuffer());
  }

  @Test
  public void shouldSupportSpecialCharactersInTag() {
    String specials = "`~!@#$%^&*()[]{}\\|;',./?\"";

    assertEquals(
      colorize(specials, BOLD()),
      printer
        .format("<bold>%s</bold>", specials)
        .getBuffer()
    );
  }

  @Test
  public void shouldAllowForBracketsEscapingInTags() {
    String expected = colorize("This has < and > in it.", BOLD());

    assertEquals(
      expected,
      printer
        .format("<bold>This has << and >> in it.</bold>")
        .getBuffer()
    );
  }

  @Test
  public void shouldPrintToSystemOut() {
    String expected = "This should be printed to System.out";
    ByteArrayOutputStream bs = setupStandardOut();

    printer.print(expected);

    String printed = flushOutputStream(bs);
    assertEquals(String.format(expected + "%n"), printed);
  }

  @Test
  public void shouldAllowBufferedPrinting() {
    String expected = "This should be printed to %s";
    String replacement = "System.out";
    ByteArrayOutputStream bs = setupStandardOut();

    printer.multiline(expected).print(replacement);

    String printed = flushOutputStream(bs);
    assertEquals(
      String.format(expected + "%n", replacement),
      printed);
  }

  @Test
  public void shouldSupportNoReplacementBufferPrints() {
    String expected = "This is some text!";
    ByteArrayOutputStream bs = setupStandardOut();

    printer.multiline(expected).print();

    String printed = flushOutputStream(bs);
    assertEquals(String.format(expected + "%n"), printed);
  }

  @Test
  public void shouldHaveClearBufferAfterPrint() {
    ByteArrayOutputStream bs = setupStandardOut();

    printer.multiline("Something").print();

    flushOutputStream(bs);
    assertEquals("", printer.getBuffer());
  }

  @Test
  public void multilineShouldSupportMultipleReplacements() {
    String line1 = "%s line!";
    String line2 = "%s line!";
    Object[] replacements = { "First", "Second" };

    ByteArrayOutputStream bs = setupStandardOut();

    printer
      .multiline(line1, line2)
      .print((String) replacements[0], replacements[1]);

    String printed = flushOutputStream(bs);
    assertEquals(
      String.format(line1 + "%n" + line2 + "%n", replacements),
      printed);
  }

  @Test
  public void shouldSupportWaitDots() {
    ByteArrayOutputStream bs = setupStandardOut();
    long startTime = System.currentTimeMillis();

    printer.wait(2, "Wait Test");

    String printed = flushOutputStream(bs);
    assertEquals(String.format("Wait Test..%n"), printed);

    long timeDiff = System.currentTimeMillis() - startTime;
    assertTrue(timeDiff > 2000 && timeDiff < 3000);
  }

  @Test
  public void shouldBeAbleToChainWait() {
    ByteArrayOutputStream bs = setupStandardOut();

    printer.multiline("Test").wait(2);

    String printed = flushOutputStream(bs);
    assertEquals(String.format("Test..%n"), printed);
  }

  @Test
  public void shouldNotWaitWhenInTestMode() {
    ByteArrayOutputStream bs = setupStandardOut();
    long startTime = System.currentTimeMillis();

    Printer printer = new Printer();
    printer.disableSleep();
    printer.wait(10, "TEST_MODE");

    String printed = flushOutputStream(bs);
    assertEquals(
      String.format("TEST_MODE..........%n"),
      printed);

    long timeDiff = System.currentTimeMillis() - startTime;
    assertTrue(timeDiff < 1000);
  }

  @Test
  public void shouldSupportSameLinePrinting() {
    ByteArrayOutputStream bs = setupStandardOut();

    printer.inline().print("Test");

    String printed = flushOutputStream(bs);
    assertEquals("Test", printed);
  }

  @Test
  public void shouldClearTheInlineFlagAfterPrinting() {
    ByteArrayOutputStream bs = setupStandardOut();

    printer.inline().print("Test");
    printer.print(" Test 2!");

    String printed = flushOutputStream(bs);
    assertEquals(
      String.format("Test Test 2!%n"),
      printed);
  }

}
