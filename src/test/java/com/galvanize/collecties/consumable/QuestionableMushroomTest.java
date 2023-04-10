package com.galvanize.collecties.consumable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Consumable: Questionable Mushroom")
public class QuestionableMushroomTest {

    QuestionableMushroom mushroom;

    @BeforeEach
    public void testSetup() {
        mushroom = new QuestionableMushroom();
    }

    @Test
    public void shouldHaveTheRightName() {
        assertEquals("Questionable Mushroom", mushroom.getName());
    }

    @Test
    public void shouldOnlyHaveOneUsage() {
        assertTrue(mushroom.consume());
    }
}

