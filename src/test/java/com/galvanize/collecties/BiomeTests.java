package com.galvanize.collecties;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Biome Enum")
public class BiomeTests {

  @Test
  public void shouldBeAbleToGetARandomBiome() {
    Biome biome1 = Biome.getRandomBiome();
    assertNotNull(biome1);
  }
}
