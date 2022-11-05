package com.unimol.cocktailparadise.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static Retrofit mysqlretrofit;

    private static String BASE_URL = "https://www.thecocktaildb.com/";
    private static String MYSQL_BASE_URL = "https://2512-213-45-198-238.eu.ngrok.io/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static Retrofit getRetrofitInstanceMYSQL() {
        if (mysqlretrofit == null) {
            mysqlretrofit = new Retrofit.Builder()
                    .baseUrl(MYSQL_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mysqlretrofit;
    }


}
