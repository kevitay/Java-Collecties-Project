package com.galvanize.collecties.consumable;

import com.galvanize.collecties.Biome;

public class Protein implements Consumable {

      private int grams = 4;

      @Override
      public String getName() {
           return String.format(
             "Consume (%d) grams of Yeti protein.", grams);
      }

      @Override
      public boolean consume() {
           if(grams == 0) return true;

           grams--;
           return grams == 0;
      }

      @Override
      public Consumable clone() { return new Protein(); }

    @Override
    public Biome getContainingBiome() {
        return Biome.PLAINS;
    }
 }




