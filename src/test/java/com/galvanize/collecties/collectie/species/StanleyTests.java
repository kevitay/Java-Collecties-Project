package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: SouthPark")
public class StanleyTests {

    Stanley stan;

    @BeforeEach
    public void testSetup() {
        stan = new Stanley();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Stan";
        stan.setName(newName);
        assertEquals(newName, stan.getName());

    }

    @Test
    public void shouldReturnGraphic() {
        String graphic = stan.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldReturnPreferredBiome() {
        assertEquals(Biome.MOUNTAIN_RANGE, stan.getPreferredBiome());
    }

    @Test
    public void shouldHave12AttackPower() {
        assertEquals(12, stan.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins = 0;
        for(int i = 0; i < 1000; i++) {
            if(stan.defend(0)) wins++;
        }
        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldCloneNewStanley() {
        Stanley clone = stan.clone();
        assertNotEquals(clone, stan);
    }

    @Test
    public void shouldGetSpecies() {
        assertEquals("Stanley", stan.getSpecies());
    }

    @Test
    public void shouldBeTypeSpecial() {
        assertEquals(CollectieType.SPECIAL, stan.getType());
    }

    @Test
    public void shouldHaveCorrectSound() {
        assertEquals("YOU KNOW, I LEARNED SOMETHING TODAY", stan.speak());
    }
}

