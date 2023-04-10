package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Consumable: TruBlood Drink")
public class TruBloodTests {

    TruBlood drink;

    @BeforeEach
    public void testSetup() {
        drink = new TruBlood();
    }

    @Test
    public void shouldHaveCorrectName() {
        Assertions.assertEquals("You quench your thirst for blood with a pint of TruBlood.", drink.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage(){
        Assertions.assertTrue(drink.consume());
    }
}
