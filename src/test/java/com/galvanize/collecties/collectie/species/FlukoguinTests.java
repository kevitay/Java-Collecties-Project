package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Flukoguin")
public class FlukoguinTests {

    Flukoguin fluko;

    @BeforeEach
    public void testSetup() {
        fluko = new Flukoguin();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Flukaro";
        fluko.setName(newName);
        Assertions.assertEquals(newName, fluko.getName());
    }

    @Test
    public void shouldBeFlukoguinSpecies() {
        assertEquals("Flukoguin", fluko.getSpecies());
    }

    @Test
    public void shouldBeTypeSpecial() {
        Assertions.assertEquals(CollectieType.SPECIAL, fluko.getType());
    }





}
