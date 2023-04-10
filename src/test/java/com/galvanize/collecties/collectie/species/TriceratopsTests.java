package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Triceratops")
public class TriceratopsTests {

    Triceratops tops;

    @BeforeEach
    public void testSetup() {
        tops = new Triceratops();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Tritops";
        tops.setName(newName);
        assertEquals(newName, tops.getName());
    }

    @Test
    public void shouldBeTriceratopsSpecies() {
        assertEquals("Triceratops", tops.getSpecies());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = tops.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("ROAR", tops.speak());
    }

    @Test
    public void shouldPreferVolcanicBiomes() {
        assertEquals(Biome.PLAINS, tops.getPreferredBiome());
    }

    @Test
    public void shouldHave70AttackPower() {
        assertEquals(70, tops.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend75pOfTheTime() {
        int wins = 0;
        for (int i = 0; i < 1000; i++) {
            if (tops.defend(0)) wins++;
        }
        System.out.println("Wins: " + wins);
        assertTrue(wins > 700 && wins < 800);
    }

    @Test
    public void shouldNewTriceratopsOnClone() {
        Triceratops clone = tops.clone();
        assertNotEquals(clone, tops);
    }
}
