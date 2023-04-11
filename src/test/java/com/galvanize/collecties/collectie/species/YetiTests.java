package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Yeti")
public class YetiTests {

    Yeti yeti;

    @BeforeEach
    public void testSetup() {
        yeti = new Yeti();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Bigfoot";
        yeti.setName(newName);
        assertEquals(newName, yeti.getName());
    }

    @Test
    public void shouldBeYetiSpecies() {
        assertEquals("Yeti", yeti.getSpecies());
    }


    @Test
    public void shouldBeTypeSpecial() {
        Assertions.assertEquals(CollectieType.SPECIAL, yeti.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = yeti.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {assertEquals("WHISTLING SWOOSH", yeti.speak()); }

    @Test
    public void shouldHaveTheMountainRangeBiome() { assertEquals(Biome.MOUNTAIN_RANGE, yeti.getPreferredBiome());}

    @Test
    public void shouldHave10AttackPower() {assertEquals(10, yeti.performAttack());}

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins = 0;
        for(int i = 0; i < 1000; i++) {
            if(yeti.defend(0)) wins++;
        }
    System.out.println("Wins: " + wins);
    assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewYetiOnClone() {
        Yeti clone = yeti.clone();
        assertNotEquals(clone, yeti);
    }

}

