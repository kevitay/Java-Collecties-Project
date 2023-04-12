package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Consumable: Dinghy")
public class DinghyFoodTests {

    Dinghy food;

    @BeforeEach
    public void testSetup() {
        food = new Dinghy();
    }

    @Test
    public void shouldHaveTheRightFood() {
        Assertions.assertEquals("chunk of a dinghy (2)", food.getName());
    }

    @Test
    public void shouldHaveTwoBitesToConsume() {
        Assertions.assertFalse(food.consume());
        Assertions.assertTrue(food.consume());
    }

    @Test
    public void shouldShowBiteCountInName() {
        Assertions.assertTrue(food.getName().contains("(2)"));
        food.consume();
        Assertions.assertTrue(food.getName().contains("(1)"));
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        Dinghy item = new Dinghy();
        assertEquals(Biome.PLAINS, item.getContainingBiome());
    }
}
