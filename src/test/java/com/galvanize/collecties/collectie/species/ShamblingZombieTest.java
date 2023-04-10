package com.galvanize.collecties.collectie.species;

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

}
