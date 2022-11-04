package com.unimol.cocktailparadise.adapters;

public class DrinkItem {

    String strDrink;
    String strCategory;
    int idDrink;
    String strDrinkThumb;
    String strInstructionsIT;
    String strGlass;
    String strAlcoholic;


    public DrinkItem(String drinkName, String categoryName, int idDrink, String imageView) {
        this.strDrink = drinkName;
        this.strCategory = categoryName;
        this.idDrink = idDrink;
        this.strDrinkThumb = imageView;
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
}
