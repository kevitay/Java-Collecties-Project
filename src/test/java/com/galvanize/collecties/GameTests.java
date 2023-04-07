package com.galvanize.collecties;

import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.galvanize.collecties.GameHelper.runGameWithInput;

public class GameTests {

    @BeforeEach
    public void setup() {
    }

    @Test
    public void canExitGame() throws IOException {
        String input = "n\n4\n";
        String output = runGameWithInput(input);
        System.out.println(output);
        Assertions.assertTrue(output.toString().contains("Thank you for playing!"));
    }

    @Test
    public void showCollectionThenExit() {
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "3", "1", "6", "4"));
//        String input = "n\n3\n1\n6\n4\n";
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
