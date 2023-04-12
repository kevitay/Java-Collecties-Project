package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: VeganHotdogs")
public class VeganHotdogsTest {

   VeganHotdogs veganHotdogs;

   @BeforeEach
   public void testSetup() {
       veganHotdogs = new VeganHotdogs();
   }

    @Test
    public void shouldHaveTheRightName() {
        Assertions.assertEquals( "","" );
    }

    @Test
    public void shouldHaveVeganHotDogsToConsume() {
       assertFalse(veganHotdogs.consume());
       assertTrue(veganHotdogs.consume());



    }
    @Test
    public VeganHotdogs clone() {
        return new VeganHotdogs();
    }

    @Test
    public void shouldReturnBiomeForConsumable() {
        VeganHotdogs item = new VeganHotdogs();
        assertEquals(Biome.MOUNTAIN_RANGE, item.getContainingBiome());
    }
}
