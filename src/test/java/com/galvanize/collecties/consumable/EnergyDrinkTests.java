package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Energy Drink")
public class EnergyDrinkTests {

  EnergyDrink drink;

  @BeforeEach
  public void testSetup() {
    drink = new EnergyDrink();
  }

  @Test
  public void shouldHaveTheRightName() {
    assertEquals("Rextore Claws Energy Drink", drink.getName());
  }

  @Test
  public void shouldOnlyHaveOneUsage() {
    assertTrue(drink.consume());
  }
}
