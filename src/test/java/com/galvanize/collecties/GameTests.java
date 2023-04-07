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

public class GameTests {
    PrintStream printStream;
    InputStream inputStream;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
//        this.inputStream = new ByteArrayInputStream("".getBytes());
        this.outputStream = new ByteArrayOutputStream();
        this.printStream = new PrintStream(this.outputStream);
//        System.setOut(this.printStream);
//        System.setIn(this.inputStream);
    }

    public void runGameWithInput(List<String> inputList) {
        runGameWithInput(String.join("\n", inputList));
    }
    public void runGameWithInput(String input) {
        this.inputStream = new ByteArrayInputStream(input.getBytes());
        Printer printer = new Printer(this.printStream);
        Scanner scanner = new Scanner(this.inputStream);
        Prompt prompt = new Prompt(scanner, printer);
        Game game = new Game(printer, prompt);
        game.start();
    }

    @Test
    public void canExitGame() throws IOException {
        String input = "n\n4\n";
        runGameWithInput(input);
        System.out.println(outputStream);
        Assertions.assertTrue(outputStream.toString().contains("Thank you for playing!"));
    }

    @Test
    public void showCollectionThenExit() {
        List<String> gameInput = new ArrayList<>(Arrays.asList("n", "3", "1", "6", "4"));
//        String input = "n\n3\n1\n6\n4\n";
        runGameWithInput(gameInput);
        System.out.println(outputStream);
        Assertions.assertTrue(outputStream.toString().contains("Collectie Collection"));
    }

    public ByteArrayOutputStream setupStandardOut() {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bs));

        return bs;
    }

    /*
     * Flush the given output stream and return the text
     * written to it.
     */
    public String flushOutputStream(ByteArrayOutputStream bs) {
        try {
            bs.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return "";
        }

        return bs.toString();
    }
}
