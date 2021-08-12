package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Consumables Enum")
public class ConsumablesTests {

  @Test
  public void shouldBeAbleToGetRandomConsumable() {
    Consumable consumable = Consumables.getRandomConsumable();
    assertNotNull(consumable);
  }
}
