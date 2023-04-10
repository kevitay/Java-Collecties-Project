package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Collectie: Vampire")
public class VampireTests {

    Vampire testVampire;
    @BeforeEach
    public void testSetup(){
        testVampire = new Vampire();
    }

    @Test
    public void shouldBeAbleToRename(){
        //setup
        String newName = "Count Dracula";
        //execute
        testVampire.setName(newName);
        //assessment
        Assertions.assertEquals(newName, testVampire.getName());
    }

    @Test
    public void shouldBeVampireSpecies (){
        Assertions.assertEquals("Vampire", testVampire.getSpecies());
    }

    @Test
    public void shouldBeTypeSPECIAL (){
        Assertions.assertEquals(CollectieType.SPECIAL, testVampire.getType());
    }

    @Test
    public void shouldProvideAGraphic() {
         Assertions.assertNotEquals(0, testVampire.getGraphic().length());
    }

    @Test
    public void shouldHaveTheCorrectSound(){
        String shout = "I WANT TO SUCK YOUR BLOOD";
        Assertions.assertEquals(shout, testVampire.speak());
    }

    @Test
    public void shouldPreferMountainBiome (){
        Assertions.assertEquals(Biome.MOUNTAIN_RANGE, testVampire.getPreferredBiome());
    }

    @Test
    public void shouldHave8AttackPower (){
        Assertions.assertEquals(8, testVampire.performAttack());
    }

    //public void shouldSuccessfullyDefend80pOfTheTime (){}

    //public void shouldNewVampireOnClone(){}

}
