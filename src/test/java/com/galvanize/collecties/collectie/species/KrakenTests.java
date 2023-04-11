package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Kraken")
public class KrakenTests {
    Kraken kraken;

    @BeforeEach
    public void testSetup() {
        kraken = new Kraken();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Karen";
        kraken.setName(newName);
        assertEquals(newName, kraken.getName());
    }

    @Test
    public void shouldBeKrakenSpecies() {
        assertEquals("Kraken", kraken.getSpecies());
    }

    @Test
    public void shouldBeTypeDinosaur() {
        Assertions.assertEquals(CollectieType.MONSTER, kraken.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = kraken.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("GRRRRRUUUMMMMM", kraken.speak());
    }

    @Test
    public void shouldPreferOceanicBiomes() {
        assertEquals(Biome.OCEANIC, kraken.getPreferredBiome());
    }

    @Test
    public void shouldHave10AttackPower() {
        assertEquals(10, kraken.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend60pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(kraken.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 550 && wins < 650);
    }

    @Test
    public void shouldBeNewKrakenOnClone() {
        Kraken clone = kraken.clone();
        assertNotEquals(clone, kraken);
    }
}
