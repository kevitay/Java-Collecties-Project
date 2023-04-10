package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Cartman")
public class CartmanTest {
    Cartman cartman;
    @BeforeEach
    public void testSetup() { cartman = new Cartman(); }


    @Test
    public void shouldBeAbleToRename() {
        String newName = "ChubbyCartman";
        cartman.setName(newName);
        assertEquals(newName,cartman.getName());

    }
}

