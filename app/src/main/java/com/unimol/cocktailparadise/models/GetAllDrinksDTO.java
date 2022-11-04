package com.unimol.cocktailparadise.models;

import java.util.ArrayList;

public class GetAllDrinksDTO {

    ArrayList<Drink.drinks> drinks;

    public ArrayList<Drink.drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink.drinks> drinks) {
        this.drinks = drinks;
    }


}
