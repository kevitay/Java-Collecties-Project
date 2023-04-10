package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Collectie: Shambling Zombie")
public class ShamblingZombieTest {

    ShamblingZombie shamblingzombie;

    @BeforeEach
    public void testSetup() {
        shamblingzombie = new ShamblingZombie();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Shambling Zombie";
        shamblingzombie.setName(newName);
        Assertions.assertEquals(newName, shamblingzombie.getName());
    }

    @Test
    public void shouldBeShamblingZombieSpecies() {
        Assertions.assertEquals("ShamblingZombie", shamblingzombie.getSpecies());
    }

    @Test
    public void shouldBeTypeGhost() {
        Assertions.assertEquals(CollectieType.GHOST, shamblingzombie.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = shamblingzombie.getGraphic();
        System.out.println(graphic);
        Assertions.assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        Assertions.assertEquals("A MIND IS A TERRIBLE THING TO WASTE", shamblingzombie.speak());
    }

    @Test
    public void shouldPreferBogBiome() {
        Assertions.assertEquals(Biome.BOG, shamblingzombie.getPreferredBiome());
    }

    @Test
    public void shouldHave8AttackPower() {
        Assertions.assertEquals(8, shamblingzombie.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins = 0;
        for (int i = 0; i < 1000; i++) {
            if (shamblingzombie.defend(0)) wins++;
        }
        System.out.println("Wins: " + wins++);
        Assertions.assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewShamblingZombieOnClone() {
        ShamblingZombie clone = shamblingzombie.clone();
        Assertions.assertNotEquals(clone, shamblingzombie);
    }
}
