package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Consumable: TruBlood Drink")
public class TruBloodTests {

    TruBlood drink;

    @BeforeEach
    public void testSetup() {
        drink = new TruBlood();
    }

    @Test
    public void shouldHaveCorrectName() {
        Assertions.assertEquals("pint of TruBlood", drink.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage(){
        Assertions.assertTrue(drink.consume());
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        TruBlood item = new TruBlood();
        assertEquals(Biome.OCEANIC, item.getContainingBiome());
    }
}
