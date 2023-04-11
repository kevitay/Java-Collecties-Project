package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Collectie: Skeletor")

public class SkeletorTest {

    Skeletor skeletor;

    @BeforeEach
    public void testSetup() {
        skeletor = new Skeletor();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Skeleton";
        skeletor.setName(newName);
        Assertions.assertEquals(newName, skeletor.getName());
    }

    @Test
    public void shouldBeSkeletorSpecies() {
        Assertions.assertEquals("Skeletor", skeletor.getSpecies());
    }

    @Test
    public void shouldBeTypeElement() {
        Assertions.assertEquals(CollectieType.ELEMENTAL, skeletor.getType());
    }

    @Test
    public void shouldProvidetheGraphic() {
        String graphic = skeletor.getGraphic();
        System.out.println(graphic);
        Assertions.assertNotEquals(0, skeletor.getGraphic().length());
    }

    @Test
    public void shouldHaveTheCorrectNoise() {
        Assertions.assertEquals("GOT MILK?", skeletor.speak());
    }

    @Test
    public void shouldPreferDesertBiome() {
        Assertions.assertEquals(Biome.DESERT, skeletor.getPreferredBiome());
    }

    @Test
    public void shouldHaveLevel3AttackPower() {
        Assertions.assertEquals(3, skeletor.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend30PercentOfTheTime() {
        int wins = 0;
        for(int i = 0; i < 1000; i++) {
            if(skeletor.defend(3)) wins++;
        }

        System.out.println("Wins: " + wins);
        Assertions.assertTrue(wins > 250 && wins < 350);
    }

    @Test
    public void shouldNewSkeletorOnClone() {
        Skeletor clone = skeletor.clone();
        Assertions.assertNotEquals(clone, skeletor);
    }
}
