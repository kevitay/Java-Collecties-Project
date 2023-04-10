package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Collectie: WonderWoman")
public class WonderWomanTest {
    WonderWoman wonderWoman;
    @BeforeEach
    public void testSetup() {
        wonderWoman = new WonderWoman();
    }
   
    @Test
    public void shouldBeAbleToRename() {
        String newName = "WonderWoman";
        wonderWoman.setName(newName);
        assertEquals(newName, wonderWoman.getName());
        
    }


}
