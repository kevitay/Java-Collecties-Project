package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Collectie: Kenny")
public class KennyTests {
    Kenny kenny;
    @BeforeEach
    public void testSetup() { kenny = new Kenny(); }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "KennyMcCormick";
        kenny.setName(newName);
        assertEquals(newName,kenny.getName());

    }
    @Test
    public void shouldBeKennySpecies() {
        assertEquals("Kenny", kenny.getSpecies());
    }




    @Test
    public void shouldBeTypeSpecial() {

        Assertions.assertEquals(CollectieType.SPECIAL, kenny.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = kenny.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound(){
        assertEquals("WOO-HOO!",kenny.speak());
    }



}
