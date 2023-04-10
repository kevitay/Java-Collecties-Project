package com.galvanize.collecties.consumable;

public class VitaminI implements Consumable {

    @Override
    public String getName() { return "Spinach"; }

    @Override
    public boolean consume() {return true; }

    @Override
    public Consumable clone() { return new VitaminI(); }

}
