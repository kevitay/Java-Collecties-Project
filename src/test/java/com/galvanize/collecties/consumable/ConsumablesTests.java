package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumables Enum")
public class ConsumablesTests {

  @Test
  public void shouldBeAbleToGetRandomConsumableThatMatchesBiome() {
    Consumable consumable = Consumables.getRandomConsumable(Biome.MOUNTAIN_RANGE);
    assertEquals(Biome.MOUNTAIN_RANGE, consumable.getContainingBiome());
  }

  @Test
  public void returnNullForNonmatchingBiome(){
    Consumable consumable = Consumables.getRandomConsumable(Biome.BOG);
    assertNull(consumable);
  }

  @Test
  public void shouldReturnConsumableForBiome(){
    Bananas banana = new Bananas();
    Biome biome = Biome.RAINFOREST;
    assertEquals(banana.getContainingBiome(), biome);
  }
}
