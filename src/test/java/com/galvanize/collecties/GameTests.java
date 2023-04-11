package com.galvanize.collecties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.galvanize.collecties.GameHelper.*;

public class GameTests {

    @BeforeEach
    public void setup() {
    }

    @Test
    public void canExitGame() {
        String input = "n\n4\n";
        disableGameSleep();
        String output = runGameWithInput(input);
        enableGameSleep();
        System.out.println(output);
        displayOutputLines(output);
        Assertions.assertEquals("?: Thank you for playing!", output.split(System.lineSeparator())[13]);
    }

    @Test
    public void showCollectionThenExit() {
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "3", "1", "6", "4"));
        String output = runGameWithInput(gameInput);
        System.out.println(output);
        Assertions.assertTrue(output.contains("Collectie Collection"));
    }

    @Test
    public void showNoConsumablesOnGameStartThenExit() {
        String output = runGameWithInput("n", "3", "2", "6", "4");
        System.out.println(output);
        Assertions.assertTrue(output.contains("No consumables available"));
    }

    @Test
    public void canRenameCollectie() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "y", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexter (Rextore)", output.split(System.lineSeparator())[34]);
    }

    @Test
    public void canRenameCollectieNotHappyWithName() {
        String output = runGameWithInput("n", "3", "4", "1", "Rexter", "n", "Rexy", "y", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("[1] Rexy (Rextore)", output.split(System.lineSeparator())[37]);
    }

    @Test
    public void attemptToFeedCollectieWithNoConsumables() {
        hookIntoRandom();
        String output = runGameWithInput("y", "Rextor", "y", "3", "3", "1", "6", "4");
        displayOutputLines(output);
        Assertions.assertEquals("?: You have no consumables to feed Rextor!", output.split(System.lineSeparator())[26]);
    }

    @Test
    public void collectConsumable() {
        hookIntoRandom("[284789078, 57, 4]");
        disableGameSleep();
        String output = runGameWithInput("n", "2", "4");
        enableGameSleep();
        displayOutputLines(output);
        Assertions.assertEquals("You found a A fire roasted Phoenix wing (3) while exploring.", output.split(System.lineSeparator())[14]);
    }
}
