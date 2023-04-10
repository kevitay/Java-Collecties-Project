package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}