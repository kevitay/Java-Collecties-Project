package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Collectie: Flukoguin")
public class FlukoguinTests {

    Flukoguin fluko;

    @BeforeEach
    public void testSetup() {
        fluko = new Flukoguin();
    }

    @Test
    public void shouldBeAbleToRename() {
        String newName = "Flukaro";
        fluko.setName(newName);
        Assertions.assertEquals(newName, fluko.getName());
    }

    @Test
    public void shouldBeFlukoguinSpecies() {
        Assertions.assertEquals("Flukoguin", fluko.getSpecies());
    }

    @Test
    public void shouldBeTypeSpecial() {
        Assertions.assertEquals(CollectieType.SPECIAL, fluko.getType());
    }
    @Test
    public void shouldProvideAGraphic() {
        String graphic = fluko.getGraphic();
        System.out.println(graphic);
        Assertions.assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveTheCorrectSound() {
        Assertions.assertEquals("YABBADABBAYOO", fluko.speak());
    }

    @Test
    public void shouldPreferTaigaBiomes () {
        Assertions.assertEquals(Biome.TAIGA, fluko.getPreferredBiome());
    }

    @Test
    public void shouldHave75AttackPower() {
        Assertions.assertEquals(75, fluko.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins = 0;
        for (int i = 0; i < 1000; i++) {
            if(fluko.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        Assertions.assertTrue(wins > 450 && wins < 550);
    }





}
