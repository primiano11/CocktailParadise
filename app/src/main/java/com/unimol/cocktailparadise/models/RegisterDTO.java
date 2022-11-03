package com.unimol.cocktailparadise.models;

public class RegisterDTO {


    //deleteAllDrinks, deleteDrink e saveDrink

    String error_msg;
    String tag;
    Boolean status;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
