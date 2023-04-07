package com.galvanize.collecties;

import com.galvanize.collecties.Game;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class GameHelper {
    public static String runGameWithInput(String ...input) {
        return runGameWithInput(String.join("\n", input));
    }

    public static String runGameWithInput(List<String> inputList) {
        return runGameWithInput(String.join("\n", inputList));
    }

    public static String runGameWithInput(String input) {
        InputStream inputStream;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        inputStream = new ByteArrayInputStream(input.getBytes());
        Printer printer = new Printer(printStream);
        Scanner scanner = new Scanner(inputStream);
        Prompt prompt = new Prompt(scanner, printer);
        Game game = new Game(printer, prompt);
        game.start();
        return outputStream.toString();
    }
}
