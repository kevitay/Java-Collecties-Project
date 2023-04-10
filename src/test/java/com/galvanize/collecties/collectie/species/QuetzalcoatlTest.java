package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Collectie: Quetzalcoatl")
public class QuetzalcoatlTest {
    Quetzalcoatl serpent;

    @BeforeEach
    public void testSetup() {
        serpent = new Quetzalcoatl();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Quetzalcoatl";
        serpent.setName(newName);
        assertEquals(newName, serpent.getName());
    }

    @Test
    public void shouldBeQuetzalcoatlSpecies() {
        assertEquals("Quetzalcoatl", serpent.getSpecies());
    }

    @Test
    public void shouldBeTypeDinosaur() {
        Assertions.assertEquals(CollectieType.GOD, serpent.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = serpent.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("HISS", serpent.speak());
    }

    @Test
    public void shouldPreferVolcanicBiomes() {
        assertEquals(Biome.MOUNTAIN_RANGE, serpent.getPreferredBiome());
    }

    @Test
    public void shouldHave10AttackPower() {
        assertEquals(10, serpent.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(serpent.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewQuetzalcoatlOnClone() {
        Quetzalcoatl clone = serpent.clone();
        assertNotEquals(clone, serpent);
    }
}
