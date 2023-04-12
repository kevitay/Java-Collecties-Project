package com.galvanize.collecties.consumable;

public class SmellingSalts implements Consumable {

    private int bites = 1;
    @Override
    public String getName() {
        return "Smelling Salts (that will get you back into the fight)";
    }

    @Override
    public boolean consume() {
        if(this.bites == 0)
            return true;
        this.bites--;
        return this.bites == 0;
    }

    @Override
        public Consumable clone() {
            return new SmellingSalts();
        }
}
