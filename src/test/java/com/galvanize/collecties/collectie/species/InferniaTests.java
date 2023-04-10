package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Infernia")
public class InferniaTests {

  Infernia inferno;

  @BeforeEach
  public void testSetup() {
    inferno = new Infernia();
  }

  @Test
  public void shouldBeAbleToRename() {
    String newName = "flamie";
    inferno.setName(newName);
    assertEquals(newName, inferno.getName());
  }

  @Test
  public void shouldBeInferniaSpecies() {
    assertEquals("Infernia", inferno.getSpecies());
  }

  @Test
  public void shouldBeTypeElemental() {
    Assertions.assertEquals(CollectieType.ELEMENTAL, inferno.getType());
  }

  @Test
  public void shouldProvideAGraphic() {
    String graphic = inferno.getGraphic();
    System.out.println(graphic);
    assertNotEquals(0, graphic.length());
  }

  @Test
  public void shouldHaveTheCorrectSound() {
    assertEquals("BURNNNN", inferno.speak());
  }

  @Test
  public void shouldPreferVolcanicBiomes() {
    assertEquals(Biome.VOLCANIC, inferno.getPreferredBiome());
  }

  @Test
  public void shouldHave15AttackPower() {
    assertEquals(15, inferno.performAttack());
  }

  @Test
  public void shouldSuccessfullyDefend50pOfTheTime() {
    int wins =  0;
    for(int i = 0; i < 1000; i++) {
      if(inferno.defend(0)) wins++;
    }

    System.out.println("Wins: " + wins);
    assertTrue(wins > 450 && wins < 550);
  }

  @Test
  public void shouldNewInferniaOnClone() {
    Infernia clone = inferno.clone();
    assertNotEquals(clone, inferno);
  }
}
