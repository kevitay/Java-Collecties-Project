package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Bananas")
public class BananasTests {
    Bananas banana;

    @BeforeEach
    public void testSetup() {banana = new Bananas();}

    @Test public void shouldHaveTheRightName() {
        Assertions.assertEquals("Bunch of Bananas (6)", banana.getName());
    }

    @Test public void shouldHave6BananasToConsume() {
        assertFalse(banana.consume());
        assertFalse(banana.consume());
        assertFalse(banana.consume());
        assertFalse(banana.consume());
        assertFalse(banana.consume());
        assertTrue(banana.consume());
    }

    @Test
    public void shouldShowNanerCountInName() {
        assertTrue(banana.getName().contains("(6)"));
        banana.consume();
        assertTrue(banana.getName().contains("(5)"));
    }

    @Test
    public void shouldReturnBiomeForBananasConsumable() {
        Bananas banana = new Bananas();
        assertEquals(Biome.RAINFOREST, banana.getContainingBiome());
    }



}
