package com.galvanize.collecties.consumable;

public class QuestionableMushroom implements Consumable{
    @Override
    public String getName() {
        return "Questionable Mushroom";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new QuestionableMushroom();
    }
}
