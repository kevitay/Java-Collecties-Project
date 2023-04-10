package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collectie: Pheonexiumalfire")
public class PheonexiumalfireTest {

    Pheonexiumalfire pheonixy;
    @BeforeEach
    public void testSetup(){ pheonixy = new Pheonexiumalfire();}

    @Test
    public void CanRename() {
        String newName = "Pheonaxus";
        pheonixy.setName(newName);
        assertEquals(newName, pheonixy.getName());
    }
    @Test
    public void shouldBePheonexiumalfireSpecies() {
        assertEquals("Pheonexiumalfire", pheonixy.getSpecies());
    }
    @Test
    void shouldBeTypeFIRE() {
        Assertions.assertEquals(CollectieType.FIRE, pheonixy.getType());
    }


}
