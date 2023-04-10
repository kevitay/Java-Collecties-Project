package com.galvanize.collecties.consumable;

public class CoffeeDrink implements Consumable{
    @Override
    public String getName() {
        return "Cartmans Coffee Drink";
    }

    @Override
    public boolean consume() {
        return true;
    }

    @Override
    public Consumable clone() {
        return new CoffeeDrink();
    }
}
