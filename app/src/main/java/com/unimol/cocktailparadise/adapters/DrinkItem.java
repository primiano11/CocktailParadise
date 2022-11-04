package com.unimol.cocktailparadise.adapters;

import android.widget.ImageView;
import android.widget.TextView;

public class DrinkItem {

    String drinkName;
    String categoryName;
    int idDrink;
    String imageView;

    public DrinkItem(String drinkName, String categoryName, int idDrink, String imageView) {
        this.drinkName = drinkName;
        this.categoryName = categoryName;
        this.idDrink = idDrink;
        this.imageView = imageView;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
