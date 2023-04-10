package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Gengar")
public class GengarTests {

    Gengar gengar;

    @BeforeEach
    public void testSetup() {gengar = new Gengar();}

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Ghosty";
        gengar.setName(newName);
        assertEquals(newName, gengar.getName());
    }

    @Test
    public void shouldBeGengarSpecies() {
        assertEquals("Gengar", gengar.getSpecies());
    }

    @Test
    public void shouldBeTypeGhost() {
        assertEquals(CollectieType.GHOST, gengar.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = gengar.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("SSSSWWWSHHHSSSSSHHH", gengar.speak());
    }

    @Test
    public void shouldPreferBogBiomes() {
        assertEquals(Biome.BOG, gengar.getPreferredBiome());
    }

    @Test
    public void shouldHave2AttackPower() {
        assertEquals(2, gengar.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend75pOfTheTime() {
        int wins = 0;
        for (int i = 0; i < 1000; i++) {
            if (gengar.defend(0)) wins++;
        }
        System.out.println("Wins: " + wins);
        assertTrue(wins > 700 && wins < 800);
    }

    @Test
    public void shouldNewGengarOnClone() {
        Gengar clone = gengar.clone();
        assertNotEquals(clone, gengar);
    }


}
