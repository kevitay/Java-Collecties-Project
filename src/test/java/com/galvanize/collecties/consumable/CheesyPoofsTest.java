package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Consumable: CheesyPoofs")

public class CheesyPoofsTest {

    CheesyPoofs cheesyPoofs;

    @BeforeEach
    public void testSetup() { cheesyPoofs = new CheesyPoofs(); };

    @Test
    public void shouldReturnCheesyPoofAsConsumableName() {
        assertEquals("CheesyPoofs (15)", cheesyPoofs.getName());
    }
}
