package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: WonderWoman")
public class BatmanTest {
    Batman batman;
    @BeforeEach
    public void testSetup() {
        batman = new Batman();
    }
   
    @Test
    public void shouldBeAbleToRename() {
        String newName = "Batman";
        batman.setName(newName);
        assertEquals(newName, batman.getName());
        
    }

    @Test
    public void shouldBeBatmanSpecies() {
        assertEquals("Batman", batman.getSpecies());
    }

    @Test
    public void shouldBeTypeSpecial() {
        assertEquals(CollectieType.SPECIAL, batman.getType());
    }


    @Test
    public void shouldProvideGraphic(){
        String graphic = batman.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }

    @Test
    public void shouldHaveCorrectSound(){
        Assertions.assertEquals("POW", batman.speak());
    }

    @Test
    public void shouldPreferSavannaBiomes() {
        assertEquals(Biome.SAVANNA, batman.getPreferredBiome());
    }

    @Test
    public void shouldHave100AttackPower(){
        assertEquals(100, batman.performAttack());
    }

    @Test
    public void shouldSuccessfullyDefend85pOfTheTime(){
        int wins = 0;
        for(int i = 0; i < 1000; i++) {
            if(batman.defend(0)) wins++;
        }
        System.out.println("Wins: " + wins);
        assertTrue(wins >450&&wins<1000);
    }



    @Test
    public void shouldNewBatmanOnClone(){
      Batman clone = (Batman) batman.clone();
      assertNotEquals(clone, batman);
    }

    }


