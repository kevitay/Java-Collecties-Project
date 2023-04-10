package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Phoenix Wing")
public class PhoenixWingTests {

  PhoenixWing wing;

  @BeforeEach
  public void testSetup() {
    wing = new PhoenixWing();
  }

  @Test
  public void shouldHaveTheRightName() {
    assertEquals("A fire roasted Phoenix wing (3)", wing.getName());
  }

  @Test
  public void shouldHave3BitesToConsume() {
    assertFalse(wing.consume());
    assertFalse(wing.consume());
    assertTrue(wing.consume());
  }

  @Test
  public void shouldShowSliceCountInName() {
    assertTrue(wing.getName().contains("(3)"));
    wing.consume();
    assertTrue(wing.getName().contains("(2)"));
  }
}
