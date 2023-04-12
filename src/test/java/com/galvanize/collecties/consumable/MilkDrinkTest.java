package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Consumable: Milk")
public class MilkDrinkTest {

    Milk drink;

    @BeforeEach
    public void testSetup(){
        drink = new Milk();
    }

    @Test
    public void shouldHaveTheRightDrink() {
        Assertions.assertEquals("You strengthened your bones with milk it does the body good", drink.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage() {
        Assertions.assertTrue(drink.consume());
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        Milk item = new Milk();
        assertEquals(Biome.TAIGA, item.getContainingBiome());
    }

}
