package com.unimol.cocktailparadise.network;

import com.unimol.cocktailparadise.models.Drink;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("api/json/v1/1/search.php?s=Margarita")
    Call<Drink> getGinTonic();


    @GET("api/json/v1/1/search.php")
    Call<Drink> searchDrink(@Query("s") String s);

}
