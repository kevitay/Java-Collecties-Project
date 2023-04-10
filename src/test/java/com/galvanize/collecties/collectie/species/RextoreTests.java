package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Rextor")
public class RextoreTests {

  Rextore rexxie;

  @BeforeEach
  public void testSetup() {
    rexxie = new Rextore();
  }

  @Test
  public void shouldBeAbleToRename() {
    String newName = "Rexxor";
    rexxie.setName(newName);
    assertEquals(newName, rexxie.getName());
  }

  @Test
  public void shouldBeRextoreSpecies() {
    assertEquals("Rextore", rexxie.getSpecies());
  }

  @Test
  public void shouldBeTypeDinosaur() {
    Assertions.assertEquals(CollectieType.DINOSAUR, rexxie.getType());
  }

  @Test
  public void shouldProvideAGraphic() {
    String graphic = rexxie.getGraphic();
    System.out.println(graphic);
    assertNotEquals(0, graphic.length());
  }

  @Test
  public void shouldHaveTheCorrectSound() {
    assertEquals("RARWAR", rexxie.speak());
  }

  @Test
  public void shouldPreferVolcanicBiomes() {
    assertEquals(Biome.VOLCANIC, rexxie.getPreferredBiome());
  }

  @Test
  public void shouldHave10AttackPower() {
    assertEquals(10, rexxie.performAttack());
  }

  @Test
  public void shouldSuccessfullyDefend50pOfTheTime() {
    int wins =  0;
    for(int i = 0; i < 1000; i++) {
      if(rexxie.defend(0)) wins++;
    }

    System.out.println("Wins: " + wins);
    assertTrue(wins > 450 && wins < 550);
  }

  @Test
  public void shouldNewRextoreOnClone() {
    Rextore clone = rexxie.clone();
    assertNotEquals(clone, rexxie);
  }
}
