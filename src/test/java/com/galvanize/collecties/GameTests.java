package com.galvanize.collecties;

import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

public class GameTests {
    PrintStream printStream;
    InputStream inputStream;
    ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setup() {
        this.inputStream = new ByteArrayInputStream("n\n4\n".getBytes());
        this.outputStream = new ByteArrayOutputStream();
        this.printStream = new PrintStream(this.outputStream);
//        System.setOut(this.printStream);
//        System.setIn(this.inputStream);
    }

    @Test
    public void canExitGame() {
        Printer printer = new Printer(this.printStream);
        Scanner scanner = new Scanner(this.inputStream);
        Prompt prompt = new Prompt(scanner, printer);
        Game game = new Game(printer, prompt);
        game.start();
        System.out.println(outputStream);
        Assertions.assertTrue(outputStream.toString().contains("Thank you for playing!"));
    }

    @Test
    public void showCollectionThenExit() {
        String input = "3\n1\n6\n4\n";
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
