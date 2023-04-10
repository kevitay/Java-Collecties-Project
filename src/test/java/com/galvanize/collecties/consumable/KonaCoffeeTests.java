package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Consumable: Kona Coffee")
public class KonaCoffeeTests {

    KonaCoffee coffee;

    @BeforeEach
    public void testSetup() { coffee = new KonaCoffee(); }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Kona Coffee", coffee.getName());
    }
}
