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
        System.out.println(output);
        displayOutputLines(output);
        Assertions.assertEquals("?: Thank you for playing!", output.split("\n")[13]);
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
}
