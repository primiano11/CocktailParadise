package com.unimol.cocktailparadise.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    private static String CKDB_BASE_URL = "https://www.thecocktaildb.com/";
    private static String MYSQ_BASE_URL = "http://localhost:8089/CocktailParadiseWS/rest/";


    public static Retrofit getRetrofitInstanceCKDB(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(CKDB_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static Retrofit getRetrofitInstanceMYSQ(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(MYSQ_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}