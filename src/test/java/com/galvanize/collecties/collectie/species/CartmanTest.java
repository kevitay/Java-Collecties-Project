package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Cartman")
public class CartmanTest {
    Cartman cartman;
    @BeforeEach
    public void testSetup() { cartman = new Cartman(); }


    @Test
    public void shouldBeAbleToRename() {
        String newName = "ChubbyCartman";
        cartman.setName(newName);
        assertEquals(newName,cartman.getName());
    }

    @Test
    public void shouldBeCartmanSpecies(){
        assertEquals("Cartman", cartman.getSpecies());
    }
    @Test
    public void shouldBeTypeGhost(){
        assertEquals(CollectieType.GHOST, cartman.getType());
    }
    @Test
    public void shouldProvideAGraphic(){
        String graphic = cartman.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }
    @Test
    public void shouldHaveTheCorrectSound(){
        assertEquals("RESPECT MY AUTHORITY", cartman.speak());
    }
    @Test
    public void shouldPreferMountainRangeBiomes(){
    assertEquals(Biome.MOUNTAIN_RANGE, cartman.getPreferredBiome());
    }
@Test
    public void shouldHave100AttackPower(){
        assertEquals(100, cartman.performAttack());
}
@Test
 public void shouldSuccessfullyDefend50pOfTheTime(){
    int wins = 0;
    for (int i = 0; i < 1000; i++){
        if (cartman.defend(0)) wins++;
    }
    System.out.println("Wins: " + wins);
    assertTrue(wins > 450 && wins < 550);
}
@Test
    public void shouldGetNewCartmanOnClone(){
        Cartman clone = cartman.clone();
        assertNotEquals(clone, cartman);
}
}

