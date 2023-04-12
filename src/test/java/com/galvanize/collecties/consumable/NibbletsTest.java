package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NibbletsTest {
    Nibblets nibblets;

    @BeforeEach
    public void testSetup() {
        nibblets = new Nibblets();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Nibblets", nibblets.getName());
    }

    @Test
    public void ShouldHaveaSingleConsumption() {
        assertTrue(nibblets.consume());

    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        Nibblets item = new Nibblets();
        assertEquals(Biome.WOODLAND, item.getContainingBiome());
    }
}
