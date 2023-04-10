package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@DisplayName("Consumable: Bananas")
public class BananasTests {
    Bananas banana;

    @BeforeEach
    public void testSetup() {banana = new Bananas();}

    @Test public void shouldHaveTheRightName() {
        Assertions.assertEquals("Bunch of Bananas", banana.getName());
    }


}
