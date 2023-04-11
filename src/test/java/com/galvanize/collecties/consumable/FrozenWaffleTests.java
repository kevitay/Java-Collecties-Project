package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Frozen Waffle")
public class FrozenWaffleTests {

    FrozenWaffle frozenwaffle;

    @BeforeEach
    public void testSetup() {
        frozenwaffle = new FrozenWaffle();
    }
}
