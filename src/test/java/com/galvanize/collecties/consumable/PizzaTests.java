package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Pizza")
public class PizzaTests {

  Pizza pizza;

  @BeforeEach
  public void testSetup() {
    pizza = new Pizza();
  }

  @Test
  public void shouldHaveTheRightName() {
    assertEquals("Small Pizza with Dodud Sausage (4)", pizza.getName());
  }

  @Test
  public void shouldHave4SlicesToConsume() {
    assertFalse(pizza.consume());
    assertFalse(pizza.consume());
    assertFalse(pizza.consume());
    assertTrue(pizza.consume());
  }

  @Test
  public void shouldShowSliceCountInName() {
    assertTrue(pizza.getName().contains("(4)"));
    pizza.consume();
    assertTrue(pizza.getName().contains("(3)"));
  }

  @Test
  public void shouldReturnBiomeForConsumable() {
    Pizza item = new Pizza();
    assertEquals(Biome.VOLCANIC, item.getContainingBiome());
  }
}
