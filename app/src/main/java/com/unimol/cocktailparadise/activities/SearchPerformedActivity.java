package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.adapters.DrinkAdapter;
import com.unimol.cocktailparadise.adapters.DrinkItem;
import com.unimol.cocktailparadise.models.Drink;
import com.unimol.cocktailparadise.network.ApiService;
import com.unimol.cocktailparadise.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchPerformedActivity extends AppCompatActivity {

    private TextView noResultsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_performed);
        this.noResultsTextView = findViewById(R.id.noResultsTextView);

        Intent intent = getIntent();
        String strDrink = intent.getStringExtra("strDrink");
        Context context = getApplicationContext();

        ApiService apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
        Call<Drink> call = apiService.searchDrink(strDrink);

        call.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {

                List<DrinkItem> itemList = new ArrayList<>();
                ArrayList<Drink.drinks> responseDrinks = response.body().getDrinks();

                if(responseDrinks != null){
                    for (Drink.drinks drinks:responseDrinks) {
                        itemList.add(new DrinkItem(drinks.getStrDrink(), drinks.getStrCategory(), drinks.getIdDrink(), R.drawable.logo2));
                        Log.e("CIAO", "Drink name: " +drinks.getStrDrink() + "Drink id: " +drinks.getIdDrink());
                    }

                    RecyclerView recyclerView = findViewById(R.id.recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new DrinkAdapter(getApplicationContext(), itemList));
                } else {

                    noResultsTextView.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {

            }
        });

    }
}