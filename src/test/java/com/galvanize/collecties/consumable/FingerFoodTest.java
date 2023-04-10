package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Consumable: Finger Food")
public class FingerFoodTest {

    FingerFood food;

    @BeforeEach
    public void testSetup() {
        food = new FingerFood();
    }

    @Test
    public void shouldHaveTheRightFood() {
        Assertions.assertEquals("You enjoy a delicious finger food (4)", food.getName());
    }

    @Test
    public void shouldHave4FingersToConsume() {
        Assertions.assertFalse(food.consume());
        Assertions.assertFalse(food.consume());
        Assertions.assertFalse(food.consume());
        Assertions.assertTrue(food.consume());
    }

    @Test
    public void shouldShowFingerCountInName() {
        Assertions.assertTrue(food.getName().contains("(4)"));
        food.consume();
        Assertions.assertTrue(food.getName().contains("(3)"));
    }
}
