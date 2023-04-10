package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Kenny")
public class KennyTests {
    Kenny kenny;
    @BeforeEach
    public void testSetup() { kenny = new Kenny(); }


    @Test
    public void shouldBeAbleToRename() {
        String newName = "KennyMcCormick";
        kenny.setName(newName);
        assertEquals(newName,kenny.getName());

    }

}
