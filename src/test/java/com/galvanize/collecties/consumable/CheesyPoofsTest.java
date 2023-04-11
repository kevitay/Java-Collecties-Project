package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: CheesyPoofs")

public class CheesyPoofsTest {

    CheesyPoofs cheesyPoofs;

    @BeforeEach
    public void testSetup() { cheesyPoofs = new CheesyPoofs(); };

    @Test
    public void shouldReturnCheesyPoofAsConsumableName() {
        assertEquals("CheesyPoofs (15)", cheesyPoofs.getName());
    }

    @Test
    public void shouldConsumeFourCheesyPoofs() {
        cheesyPoofs.consume();
        cheesyPoofs.consume();
        cheesyPoofs.consume();
        cheesyPoofs.consume();

        assertEquals("CheesyPoofs (11)", cheesyPoofs.getName());
    }

    @Test
    public void canConsume15CheesyPoofs() {
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertFalse(cheesyPoofs.consume());
        assertTrue(cheesyPoofs.consume());
    }


}
