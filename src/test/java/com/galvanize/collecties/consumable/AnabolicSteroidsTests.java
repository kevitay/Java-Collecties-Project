package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Consumable: Anabolic Steroids")
public class AnabolicSteroidsTests {

    AnabolicSteroids steroids;

    @BeforeEach
    public void testSetup() {
        steroids = new AnabolicSteroids();
    }

    @Test
    public void shouldHaveTheRightConsumable() {
        assertEquals("The steroids is working! You're now jacked!", steroids.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage() {
        assertTrue(steroids.consume());
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        AnabolicSteroids item = new AnabolicSteroids();
        assertEquals(Biome.VOLCANIC, item.getContainingBiome());
    }

}
