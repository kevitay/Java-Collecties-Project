package com.galvanize.collecties.consumable;

public class AnabolicSteroids implements Consumable{


    @Override
    public String getName() {
        return "The steroids is working! You're now jacked!";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone()  {
        return new AnabolicSteroids();
    }
}
