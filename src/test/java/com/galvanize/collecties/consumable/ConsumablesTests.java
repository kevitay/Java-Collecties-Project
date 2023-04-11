package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumables Enum")
public class ConsumablesTests {

  @Test
  public void shouldBeAbleToGetRandomConsumable() {
    Consumable consumable = Consumables.getRandomConsumable();
    assertNotNull(consumable);
  }

  @Test
  public void shouldReturnBiomeForConsumable() {
    Bananas banana = new Bananas();
    assertEquals(Biome.RAINFOREST, banana.getContainingBiome());
  }
}
