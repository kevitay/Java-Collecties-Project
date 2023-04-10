package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
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

    @Test
    public void shouldProvideAGraphic() {
        String graphic = galvania.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("ZZZZZZAAAAAAPPPPPP", galvania.speak());
    }

    @Test
    public void shouldPreferPlainsBiomes() {
        assertEquals(Biome.PLAINS, galvania.getPreferredBiome());
    }
}
