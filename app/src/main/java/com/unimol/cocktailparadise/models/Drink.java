package com.unimol.cocktailparadise.models;

import java.util.ArrayList;

public class Drink {

    ArrayList<drinks> drinks;

    public ArrayList<drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<drinks> drinks) {
        this.drinks = drinks;
    }

    public class drinks {

        int idDrink;
        String strDrink;
        String strCategory;
        String strAlcoholic;
        String strInstructionsIT;
        String strGlass;

        public String getStrAlcoholic() {
            return strAlcoholic;
        }

        public void setStrAlcoholic(String strAlcoholic) {
            this.strAlcoholic = strAlcoholic;
        }

        public String getStrInstructionsIT() {
            return strInstructionsIT;
        }

        public void setStrInstructionsIT(String strInstructionsIT) {
            this.strInstructionsIT = strInstructionsIT;
        }

        public String getStrGlass() {
            return strGlass;
        }

        public void setStrGlass(String strGlass) {
            this.strGlass = strGlass;
        }

        public String getStrDrinkThumb() {
            return strDrinkThumb;
        }

        public void setStrDrinkThumb(String strDrinkThumb) {
            this.strDrinkThumb = strDrinkThumb;
        }

        String strDrinkThumb;


        public String getStrCategory() {
            return strCategory;
        }

        public void setStrCategory(String strCategory) {
            this.strCategory = strCategory;
        }

        public int getIdDrink() {
            return idDrink;
        }

        public void setIdDrink(int idDrink) {
            this.idDrink = idDrink;
        }

        public String getStrDrink() {
            return strDrink;
        }

        public void setStrDrink(String strDrink) {
            this.strDrink = strDrink;
        }

        @Override
        public String toString() {
            return this.strDrink + "\n" + this.strCategory;
        }
    }

}
