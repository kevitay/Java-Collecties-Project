package com.galvanize.collecties.consumable;

public class FingerFood implements Consumable {

    private int fingers = 4;

    @Override
    public String getName() {
        return String.format(
                "You enjoy a delicious finger food (%d)",fingers);
    }

    @Override
    public boolean consume() {
        if(fingers == 0) return true;

        fingers--;
        return fingers == 0;
    }

    @Override
    public Consumable clone() {
        return new FingerFood();
    }
}
