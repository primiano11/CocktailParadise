package com.unimol.cocktailparadise.network;

import com.unimol.cocktailparadise.models.Drink;
import com.unimol.cocktailparadise.models.DrinkResponseDTO;
import com.unimol.cocktailparadise.models.LoginDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DrinkService {

    @POST("CocktailParadiseWS/rest/drink/savedrink")
    Call<DrinkResponseDTO> saveDrink(@Query("idDrink") int idDrink, @Query("strDrink") String strDrink,
                                     @Query("strCategory") String strCategory, @Query("strAlcoholic") String strAlcoholic,
                                     @Query("strGlass") String strGlass, @Query("strInstructionsIT") String strInstructionsIT,
                                     @Query("userId") int userId, @Query("strDrinkThumb") String strDrinkThumb);

    @POST("CocktailParadiseWS/rest/drink/deletedrink")
    Call<DrinkResponseDTO> deleteDrink(@Query("idDrink") int idDrink, @Query("userId") int userId);

    @GET("CocktailParadiseWS/rest/drink/getalldrinks")
    Call<Drink> getAllDrinks(@Query("userId") int userId);

}
