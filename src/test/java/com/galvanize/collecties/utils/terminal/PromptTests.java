package com.galvanize.collecties.utils.terminal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Prompt")
public class PromptTests {

  private Prompt prompt;
  private Printer mockPrinter;

  // We must call the setup explicitly because
  // the scanner "mock" requires input text
  public void setupTest(String inputText) {
    Scanner scanner = new Scanner(
      new ByteArrayInputStream(inputText.getBytes()));

    mockPrinter = mock(Printer.class);
    when(mockPrinter.inline()).thenReturn(mockPrinter);

    prompt = new Prompt(scanner, mockPrinter);
  }

  @Test
  public void shouldBeAbleToGetString() {
    String testString = "Test String";
    setupTest(testString);

    String actual = prompt.getString();

    verify(mockPrinter, times(1)).print(Prompt.promptString);
    assertEquals(testString, actual);
  }

  @Test
  public void getStringShouldReturnEmptyOnFail() {
    String testString = "";
    setupTest(testString);

    String actual = prompt.getString();

    verify(mockPrinter, times(1)).print(Prompt.promptString);
    assertEquals(testString, actual);
  }

  @Test
  public void getChoiceShouldShowErrorMessageForNotIntegerInput() {

    // Have to end with a valid input to prevent infinite loop
    setupTest("f\n1");

    prompt.getChoice(2);

    verify(mockPrinter).print(Prompt.invalidInputMessage);
  }

  @Test
  public void getChoiceShouldShowErrorMessageForOutOfRange() {

    // Have to end with a valid input to prevent infinite loop
    setupTest("10\n1");

    prompt.getChoice(2);

    verify(mockPrinter).print(Prompt.invalidInputMessage);
  }

  @Test
  public void getChoiceShouldReturnTheValidChoice() {
    setupTest("10\n5\n15\n2");

    int actual = prompt.getChoice(4);

    assertEquals(2, actual);
  }


  @Test
  public void shouldBeAbleToGetYesNo() {
    setupTest("y\nyes\nn\nno");

    boolean actual = prompt.getYesNo();

    verify(mockPrinter).print("[y/n]");
    assertTrue(actual);

    actual = prompt.getYesNo();
    assertTrue(actual);

    actual = prompt.getYesNo();
    assertFalse(actual);

    actual = prompt.getYesNo();
    assertFalse(actual);
  }

  @Test
  public void yesNoShouldShowErrorOnInvalidChoice() {
    setupTest("10\nn");

    prompt.getYesNo();

    verify(mockPrinter).print(Prompt.invalidInputMessage);
  }

  @Test
  public void yesNoShouldReturnValidChoice() {
    setupTest("10\nn");

    boolean actual = prompt.getYesNo();

    assertFalse(actual);
  }
}
