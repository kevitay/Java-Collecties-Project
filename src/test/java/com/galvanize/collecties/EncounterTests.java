package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.species.Yeti;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testSetup() {
        System.out.println(encounter.getOpponent());
    }

    @Test
    public void attackOfOpportunity() {
        encounter.start();

    }
}
