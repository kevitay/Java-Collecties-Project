package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Collectie: Cartman")
public class CartmanTest {
    Cartman cartman;
    @BeforeEach
    public void testSetup() { cartman = new Cartman(); }


    @Test
    public void shouldBeAbleToRename() {
        String newName = "ChubbyCartman";
        cartman.setName(newName);
        assertEquals(newName,cartman.getName());
    }

    @Test
    public void shouldBeCartmanSpecies(){
        assertEquals("Cartman", cartman.getSpecies());
    }
    @Test
    public void shouldBeTypeGhost(){
        assertEquals(CollectieType.GHOST, cartman.getType());
    }
    @Test
    public void shouldProvideAGraphic(){
        String graphic = cartman.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }
    @Test
    public void shouldHaveTheCorrectSound(){
        assertEquals("RESPECT MY AUTHORITY", cartman.speak() );
    }
}

