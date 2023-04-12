package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Frozen Waffle")
public class FrozenWaffleTests {

    FrozenWaffle frozenwaffle;

    @BeforeEach
    public void testSetup() {
        frozenwaffle = new FrozenWaffle();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Frozen waffle without any side dishes (2)", frozenwaffle.getName());
    }

    @Test
    public void shouldHave2SlicesToConsume() {

        assertFalse(frozenwaffle.consume());
        assertTrue(frozenwaffle.consume());
    }

    @Test
    public void shouldShowSliceCountInName() {
        assertTrue(frozenwaffle.getName().contains("(2)"));
        frozenwaffle.consume();
        assertTrue(frozenwaffle.getName().contains("(1)"));
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        FrozenWaffle item = new FrozenWaffle();
        assertEquals(Biome.MOUNTAIN_RANGE, item.getContainingBiome());
    }
}
