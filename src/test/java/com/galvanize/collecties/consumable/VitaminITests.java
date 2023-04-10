package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;

public class VitaminITests implements Consumable {

    VitaminI vitaminI;

    @BeforeEach
    public void testSetUp() {
        vitaminI = new VitaminI(); }
    @Tests
    public  String getName() { return "Spinach"; }

    @Override
    public boolean consume() {return true; }

    @Override
    public Consumable clone() { return new VitaminI(); }

}
