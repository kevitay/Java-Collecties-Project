package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Galva")
public class GalvaTests {

    Galva galvania;

    @BeforeEach
    public void testSetup() {
        galvania = new Galva();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Galvania";
        galvania.setName(newName);
        assertEquals(newName, galvania.getName());
    }

    @Test
    public void shouldBeGalvaSpecies() {
        assertEquals("Galva", galvania.getSpecies());
    }

    @Test
    public void shouldBeTypeElemental() {
        assertEquals(CollectieType.ELEMENTAL, galvania.getType());
    }
}
