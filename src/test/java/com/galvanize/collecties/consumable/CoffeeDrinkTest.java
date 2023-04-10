package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Cartman's Coffee Drink")

public class CoffeeDrinkTest {

    CoffeeDrink drink;

    @BeforeEach
    public void testSetup(){drink = new CoffeeDrink(); }

    @Test
    public void shouldHaveTheRightName(){
        assertEquals("Cartman's Super Terrific Coffee", drink.getName());
    }
    @Test
    public void shouldOnlyHaveOneUsage(){
        assertTrue(drink.consume());
    }
}
