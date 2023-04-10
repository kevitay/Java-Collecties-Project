package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.StdOut;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Stanley")
public class StanTests {

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
}

