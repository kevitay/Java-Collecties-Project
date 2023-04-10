package com.galvanize.collecties.collectie.species;

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


}
