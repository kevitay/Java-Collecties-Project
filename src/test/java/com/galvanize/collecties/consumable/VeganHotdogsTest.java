package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
       assertFalse((Boolean) veganHotdogs.consume());
       assertFalse((Boolean) veganHotdogs.consume());
       assertFalse((Boolean) veganHotdogs.consume());
       assertTrue((Boolean) veganHotdogs.consume());


    }
    @Test
    public VeganHotdogs clone() {
        return new VeganHotdogs();
    }
}
