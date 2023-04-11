package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.species.Yeti;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Encounter")
public class EncounterTests {
    Encounter encounter;
    Printer printer;
    Scanner scanner;
    Prompt prompt;
    Collectie challenger;
    Biome biome;
    @BeforeEach
    public void setup() {
        // need a printer
        // need a prompt
        // need a Collectie challenger
        // need a biome
        printer = new Printer();
        scanner = new Scanner(System.in);
        prompt = new Prompt(scanner, printer);
        // pick a collectie for challenger
        challenger = new Yeti();
        biome = Biome.PLAINS;
        encounter = new Encounter(printer, prompt, challenger, biome);
    }

    public String runEncounterWithInput(String input) {
        InputStream inputStream;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        inputStream = new ByteArrayInputStream(input.getBytes());
        Printer printer = new Printer(printStream);
        Scanner scanner = new Scanner(inputStream);
        Prompt prompt = new Prompt(scanner, printer);
        challenger = new Yeti();
        biome = Biome.PLAINS;
        encounter = new Encounter(printer, prompt, challenger, biome);

        return outputStream.toString();
    }
    @Test
    public void testSetup() {
        runEncounterWithInput("");
        assertNotNull(encounter.getOpponent());
    }

    @Test
    public void attackOfOpportunity() {

        System.out.println(encounter.start());
    }
}
