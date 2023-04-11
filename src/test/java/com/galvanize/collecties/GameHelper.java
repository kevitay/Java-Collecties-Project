package com.galvanize.collecties;

import com.galvanize.collecties.Game;
import com.galvanize.collecties.collectie.utils.RandomPlayback;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameHelper {
    private static boolean testMode = false;
    private static RandomPlayback fakeRandom;
    private static Random originalRandom;

    public static void disableGameSleep() {
        testMode = true;
    }

    public static void enableGameSleep() {
        testMode = false;
    }
    public static void hookIntoRandom() {
        hookIntoRandom("[]");
    }
    public static void hookIntoRandom(String sequence) {
        GameHelper.fakeRandom = new RandomPlayback();
        GameHelper.fakeRandom.setSequence(sequence);
    }

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
        if(GameHelper.fakeRandom != null) {
            GameHelper.originalRandom = Game.randogen;
            Game.randogen = fakeRandom;
        }
        if(testMode) {
            printer.disableSleep();
        }
        Game game = new Game(printer, prompt);
        game.start();
        if(GameHelper.fakeRandom != null) {
            System.out.println(fakeRandom.getGeneratedValues());
            Game.randogen = GameHelper.originalRandom;
            GameHelper.fakeRandom = null;
        }
        return outputStream.toString();
    }


    public static void displayOutputLines(String output) {
        displayOutputLines(output.split("\n"));
    }

    public static void displayOutputLines(String[] output) {
        Integer index = 0;
        for (String line :
                output) {
            System.out.println(String.format("%3d: %s", index, line));
            index++;
        }
    }
}
