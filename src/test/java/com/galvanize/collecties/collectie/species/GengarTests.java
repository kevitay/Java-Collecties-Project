package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Gengar")
public class GengarTests {

    Gengar gengar;

    @BeforeEach
    public void testSetup() {gengar = new Gengar();}

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Ghosty";
        gengar.setName(newName);
        assertEquals(newName, gengar.getName());
    }

    @Test
    public void shouldBeGengarSpecies() {
        assertEquals("Gengar", gengar.getSpecies());
    }

}
