package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Stan")
public class StanTests {

    Stan stanley;

    @BeforeEach
    public void testSetup() {
        stanley = new Stan();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Stanley";
        stanley.setName(newName);
        assertEquals(newName, stanley.getName());

    }
}

