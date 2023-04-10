package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Triceratops")
public class TriceratopsTests {

    Triceratops tops;

    @BeforeEach
    public void testSetup() {
        tops = new Triceratops();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Tritops";
        tops.setName(newName);
        assertEquals(newName, tops.getName());
    }

    @Test
    public void shouldBeTriceratopsSpecies() {
        assertEquals("Triceratops", tops.getSpecies());
    }
}
