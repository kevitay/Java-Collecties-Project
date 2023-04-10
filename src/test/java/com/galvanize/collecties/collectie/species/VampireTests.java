package com.galvanize.collecties.collectie.species;

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
}
