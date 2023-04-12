package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Consumable: Smelling Salts")
public class SmellingSaltsTest {
    SmellingSalts smellingSalt;
    @BeforeEach
    public void testSetup() {
        smellingSalt = new SmellingSalts();
    }

    @Test
    public void shouldHaveTheRightFood() {
        Assertions.assertEquals("Smelling Salts will get you back into the fight!", smellingSalt.getName());
    }

    @Test
    public void shouldBeConsumedAfterOneSniff() {
        Assertions.assertTrue(smellingSalt.consume());
    }
}
