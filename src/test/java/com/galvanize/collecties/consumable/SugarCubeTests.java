package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.species.Triceratops;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Sugar Cube")
public class SugarCubeTests {

    SugarCube sugar;

    @BeforeEach
    public void testSetup() {
        sugar = new SugarCube();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Triceratops Sugar Cubes (2)", sugar.getName());
    }

    @Test
    public void shouldHave2CubesToConsume() {
        assertFalse(sugar.consume());
        assertTrue(sugar.consume());
    }

    @Test
    public void shouldShowCubeCountInName() {
        assertTrue(sugar.getName().contains("(2)"));
        sugar.consume();
        assertTrue(sugar.getName().contains("(1)"));
    }

    @Test
    public void shouldNewSugarOnClone() {
        Consumable clone = sugar.clone();
        assertNotEquals(clone, sugar);
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        SugarCube item = new SugarCube();
        assertEquals(Biome.SAVANNA, item.getContainingBiome());
    }
}
