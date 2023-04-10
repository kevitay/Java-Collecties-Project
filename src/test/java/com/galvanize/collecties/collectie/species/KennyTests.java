package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void shouldPreferMountainRangeBiomes() {
        assertEquals(Biome.MOUNTAIN_RANGE, kenny.getPreferredBiome());
    }
    @Test
    public void shouldHave10AttackPower(){
        assertEquals(10,kenny.performAttack());
}

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(kenny.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

}
