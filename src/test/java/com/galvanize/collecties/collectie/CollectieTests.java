package com.galvanize.collecties.collectie;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Collectie Base Class")
public class CollectieTests {

  @Test
  public void shouldBeAbleToGetRandomCollectieFromBiome() {
    Collectie randomCollectie = Collectie.getRandomCollectieForBiome(Biome.PLAINS);
    assertEquals(Biome.PLAINS, randomCollectie.getPreferredBiome());
  }

  @Test
  public void shouldBeAbleToGetABiomeWithCollectiesAssignedToIt() {
    Biome randomBiome = Collectie.getRandomNonEmptyBiome();
    assertNotEquals(0, Collectie.speciesByBiomeReference.get(randomBiome).size());
  }

  @Test
  public void defaultStatusShouldBeConscious() {
    Collectie randomCollectie = Collectie.getRandomCollectieForBiome(Collectie.getRandomNonEmptyBiome());
    Assertions.assertEquals(CollectieStatus.CONSCIOUS, randomCollectie.getCollectieStatus());
  }

  @Test
  public void canUpdateCollectieConsciousStatus() {
    Collectie randomCollectie = Collectie.getRandomCollectieForBiome(Collectie.getRandomNonEmptyBiome());
    Assertions.assertEquals(CollectieStatus.CONSCIOUS, randomCollectie.getCollectieStatus());
    randomCollectie.setCollectieStatus(CollectieStatus.UNCONSCIOUS);
    Assertions.assertEquals(CollectieStatus.UNCONSCIOUS, randomCollectie.getCollectieStatus());
    randomCollectie.setCollectieStatus(CollectieStatus.CONSCIOUS);
    Assertions.assertEquals(CollectieStatus.CONSCIOUS, randomCollectie.getCollectieStatus());
  }
}
