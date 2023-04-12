package com.galvanize.collecties;

import com.galvanize.collecties.collectie.Collectie;
import com.galvanize.collecties.collectie.CollectieStatus;
import com.galvanize.collecties.collectie.species.Dodud;
import com.galvanize.collecties.collectie.species.Yeti;
import com.galvanize.collecties.utils.terminal.Printer;
import com.galvanize.collecties.utils.terminal.Prompt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static com.galvanize.collecties.GameHelper.displayOutputLines;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Encounter")
public class EncounterTests {
    Encounter encounter;
    Printer printer;
    Scanner scanner;
    Prompt prompt;
    Collectie challenger;
    Biome biome;

    public ByteArrayOutputStream runEncounterWithInput(String input) {
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

        return outputStream;
    }
        //Overloaded the run encounter with input to accept Biome & Collectie
    public ByteArrayOutputStream runEncounterWithInput(String input, Biome biome, Collectie challenger) {
        InputStream inputStream;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        inputStream = new ByteArrayInputStream(input.getBytes());
        Printer printer = new Printer(printStream);
        Scanner scanner = new Scanner(inputStream);
        Prompt prompt = new Prompt(scanner, printer);
        //challenger = new Yeti();
        //biome = Biome.PLAINS;
        encounter = new Encounter(printer, prompt, challenger, biome);

        return outputStream;
    }

    @Test
    public void changeStatusToUnconsciousOnDefeat() {
        //setup
        Dodud duddy = new Dodud();
        Biome biome = Collectie.getRandomNonEmptyBiome();
        String[] outputResult;
        do {
            //execution
            ByteArrayOutputStream output = runEncounterWithInput("1\nn\n", biome, duddy); //ATTACK!
            encounter.start();
            displayOutputLines(output.toString());
            outputResult = output.toString().split(System.lineSeparator());
            //System.out.println(outputResult);
            } while (outputResult[outputResult.length - 2].contains("Would you like to capture the wild"));
        //assertion
        assertEquals(CollectieStatus.UNCONSCIOUS, duddy.getCollectieStatus());
    }

    // If you attempt to go into battle with an unconscious protector,
    // you should automatically run from the encounter.
    @Test
    public void battleWithUnconsciousMakesPlayerRun() {
        Biome biome = Collectie.getRandomNonEmptyBiome();
        Collectie randomCollectie = Collectie.getRandomCollectieForBiome(biome);
        randomCollectie.setCollectieStatus(CollectieStatus.UNCONSCIOUS);

        ByteArrayOutputStream output = runEncounterWithInput("1\n", biome, randomCollectie);
        encounter.start();
        displayOutputLines(output.toString());
        String[] outputResult = output.toString().split(System.lineSeparator());

        assertEquals("?: You cheese it the heckin' out of there.", outputResult[outputResult.length - 1]);
    }

    @Test
    public void opponentForEncounter() {
        runEncounterWithInput("");
        assertNotNull(encounter.getOpponent());
    }

    @Test
    public void runAwaySuccessfullyFirst() {
        ByteArrayOutputStream output = runEncounterWithInput("2\n");
        encounter.start();
        displayOutputLines(output.toString());
        String[] outputResult = output.toString().split(System.lineSeparator());
        assertEquals("?: You cheese it the heckin' out of there.", outputResult[outputResult.length - 1]);
    }

    @Test
    public void runAwayWithAttackOfOpportunity() {
        runEncounterWithInput("");
        int attacks = 0;
        for (int i = 0; i < 1000; i++) {
            if(encounter.isAttackOfOpportunityLaunched()) attacks++;
        }
        System.out.println("Attacks of Opportunity: " + attacks);
        assertTrue(attacks > 450 && attacks < 550);
    }
}
