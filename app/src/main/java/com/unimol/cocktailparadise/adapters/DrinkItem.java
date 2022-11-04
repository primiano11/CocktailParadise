package com.unimol.cocktailparadise.adapters;

public class DrinkItem {

    String strDrink;
    String strCategory;
    int idDrink;
    String strDrinkThumb;
    String strInstructionsIT;
    String strGlass;
    String strAlcoholic;

    public DrinkItem(String strDrink, String strCategory, int idDrink, String strDrinkThumb, String strInstructionsIT, String strGlass, String strAlcoholic) {
        this.strDrink = strDrink;
        this.strCategory = strCategory;
        this.idDrink = idDrink;
        this.strDrinkThumb = strDrinkThumb;
        this.strInstructionsIT = strInstructionsIT;
        this.strGlass = strGlass;
        this.strAlcoholic = strAlcoholic;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

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

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
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

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }
}
