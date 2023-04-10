package com.galvanize.collecties.collectie.species;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Dodud")
public class DodudTests {

  Dodud duddy;

  @BeforeEach
  public void testSetup() {
    duddy = new Dodud();
  }

  @Test
  public void shouldBeAbleToRename() {
    String newName = "Duddy";
    duddy.setName(newName);
    assertEquals(newName, duddy.getName());
  }

  @Test
  public void shouldBeRextoreSpecies() {
    assertEquals("Dodud", duddy.getSpecies());
  }

  @Test
  public void shouldBeTypeDinosaur() {
    Assertions.assertEquals(CollectieType.SPECIAL, duddy.getType());
  }

  @Test
  public void shouldProvideAGraphic() {
    String graphic = duddy.getGraphic();
    System.out.println(graphic);
    assertNotEquals(0, graphic.length());
  }

  @Test
  public void shouldHaveTheCorrectSound() {
    assertEquals("DOOOOOO-UP", duddy.speak());
  }

  @Test
  public void shouldPreferVolcanicBiomes() {
    assertEquals(Biome.PLAINS, duddy.getPreferredBiome());
  }

  @Test
  public void shouldHaveZeroAttackPower() {
    assertEquals(0, duddy.performAttack());
  }

  @Test
  public void shouldAlwaysLoseDefense() {
    assertFalse(duddy.defend(0));
    assertFalse(duddy.defend(0));
    assertFalse(duddy.defend(0));
  }

  @Test
  public void shouldGetNewDodudOnClone() {
    Dodud clone = duddy.clone();
    assertNotEquals(clone, duddy);
  }
}
