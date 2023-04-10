package com.galvanize.collecties.collectie.species;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StanTests {
    @DisplayName("Collectie: Stan")
    public class StanTests {

        Stan stanley;

        @BeforeEach
        public void testSetup() { stanley = new Stan(); }

        @Test
        public void shouldbeAbleToRename() {
            String newName = "Stanley";

        }
    }
}
