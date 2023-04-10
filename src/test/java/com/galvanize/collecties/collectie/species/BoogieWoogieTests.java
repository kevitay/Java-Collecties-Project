package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Boogie")
public class BoogieWoogieTests {

    BoogieWoogie boogie;

    @BeforeEach
    public void testSetup() {
        boogie = new BoogieWoogie();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Woogie";
        boogie.setName(newName);
        assertEquals(newName, boogie.getName());
    }

    @Test
    public void shouldBeBoogieWoogieSpecies() {
        assertEquals("BoogieWoogie", boogie.getSpecies());
    }

    @Test
    public void shouldBeTypeGhost() {
        Assertions.assertEquals(CollectieType.GHOST, boogie.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
        String graphic = boogie.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("WHOO-OO-OO-OO", boogie.speak());
    }

    @Test
    public void shouldPreferMountainRangeBiomes() {
        assertEquals(Biome.MOUNTAIN_RANGE, boogie.getPreferredBiome());
    }

    @Test
    public void shouldHave7AttackPower() {
        assertEquals(7, boogie.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend90pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(boogie.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 850 && wins < 950);
    }

    @Test
    public void shouldNewBoogieWoogieOnClone() {
        BoogieWoogie clone = boogie.clone();
        assertNotEquals(clone, boogie);
    }
}
