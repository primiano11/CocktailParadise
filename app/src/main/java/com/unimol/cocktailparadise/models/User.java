package com.unimol.cocktailparadise.models;

import java.util.ArrayList;

public class User {

    int id;
    String mail;
    String password;
    String username;

    ArrayList<Drink.drinks> drinks;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Drink.drinks> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink.drinks> drinks) {
        this.drinks = drinks;
    }
}
