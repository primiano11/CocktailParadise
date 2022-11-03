package com.unimol.cocktailparadise.network;

import com.unimol.cocktailparadise.models.Drink;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/json/v1/1/search.php?s=Margarita")
    Call<Drink> getGinTonic();


    @GET("api/json/v1/1/search.php?s={drink}")
    Call<Drink> searchDrink(String drink);

}
