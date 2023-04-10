package com.galvanize.collecties.consumable;

import org.junit.jupiter.api.BeforeEach;

public class SpinachTests implements Consumable {

    Spinach spinach;

    @BeforeEach
    public void testSetUp() {spinach = new Spinach(); }
    @Tests
    public  String getName() { return "Spinach"; }

    @Override
    public boolean consume() {return true; }

    @Override
    public Consumable clone() { return new Spinach(); }

}
