package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Nibblets implements Consumable {
        @Override
        public String getName() {
            return "Nibblets";
        }

        @Override
        public boolean consume() {
            return true;
        }

        @Override
        public Consumable clone() {
            return new Nibblets();
        }

    @Override
    public Biome getContainingBiome() {
        return Biome.WOODLAND;
    }
    }
