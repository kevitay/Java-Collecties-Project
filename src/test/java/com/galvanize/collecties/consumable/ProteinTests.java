package com.galvanize.collecties.consumable;
//com.galvanize.collecties.consumable.Vitamin_I vitamin_i;
import com.galvanize.collecties.Biome;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Consumable: Protein")
public class ProteinTests {

    Protein protein;
        @BeforeEach
        public void testSetup() {
              protein = new Protein();
        }

        @Test
        public void shouldHaveTheRightName() { assertEquals("Consume (4) grams of Yeti protein.", protein.getName()); }

       @Test
        public void shouldHave4GramsToConsume() {
            assertFalse(protein.consume());
            assertFalse(protein.consume());
            assertFalse(protein.consume());
            assertTrue(protein.consume());
        }



    @Test
        public void shouldShowGramCountInName() {
            assertTrue(protein.getName().contains("(4)"));
            protein.consume();
            assertTrue(protein.getName().contains("(3)"));
        }

    @Test
    public void shouldReturnBiomeForConsumable() {
        Protein item = new Protein();
        assertEquals(Biome.PLAINS, item.getContainingBiome());
    }
}

