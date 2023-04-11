package com.galvanize.collecties.collectie.species;

import com.galvanize.collecties.Biome;
import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collectie: Pheonexiumalfire")
public class PheonexiumalfireTest {

    Pheonexiumalfire pheonixy;
    @BeforeEach
    public void testSetup(){ pheonixy = new Pheonexiumalfire();}

    @Test
    public void CanRename() {
        String newName = "Pheonaxus";
        pheonixy.setName(newName);
        assertEquals(newName, pheonixy.getName());
    }
    @Test
    public void shouldBePheonexiumalfireSpecies() {
        assertEquals("Pheonexiumalfire", pheonixy.getSpecies());
    }
    @Test
    void shouldBeTypeFIRE() {
        Assertions.assertEquals(CollectieType.FIRE, pheonixy.getType());
    }
    @Test
    public void shouldProvideAGraphic() {
        String graphic = pheonixy.getGraphic();
        System.out.println(graphic);
        assertNotEquals(0, graphic.length());
    }
    @Test
    public void shouldHaveTheCorrectSound() {
        assertEquals("SKADOOSH", pheonixy.speak());
    }
    @Test
    public void shouldPreferDesertBiomes() {
        assertEquals(Biome.DESERT, pheonixy.getPreferredBiome());
    }
    @Test
    public void shouldHave10AttackPower() {
        assertEquals(10, pheonixy.performAttack());
    }
    @Test
    public void shouldSuccessfullyDefend50pOfTheTime() {
        int wins =  0;
        for(int i = 0; i < 1000; i++) {
            if(pheonixy.defend(0)) wins++;
        }

        System.out.println("Wins: " + wins);
        assertTrue(wins > 450 && wins < 550);
    }

    @Test
    public void shouldNewPhoneiumalFireOnClone() {
        Collectie clone = pheonixy.clone();
        assertNotEquals(clone, pheonixy);
    }


}
