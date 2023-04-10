package com.galvanize.collecties.collectie.species;

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
}
