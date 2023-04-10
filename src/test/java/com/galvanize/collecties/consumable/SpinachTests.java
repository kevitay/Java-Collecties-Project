package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Spinach")
public class SpinachTests {

    Spinach spinach;

    @BeforeEach
    public void testSetup() {
        spinach = new Spinach();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Popeye's brand spinach (2) - gives incredible strength!", spinach.getName());
    }
}
