package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Coffee Drink")

public class CoffeeDrinkTest {

    CoffeeDrink drink;

    @BeforeEach
    public void testSetup(){drink = new CoffeeDrink(); }

    @Test
    public void shouldHaveTheRightName(){
        assertEquals("Cartmans Coffee Drink", drink.getName());
    }
    @Test
    public void shouldOnlyHaveOneUsage(){
        assertTrue(drink.consume());
    }
}
