package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.adapters.DrinkAdapter;
import com.unimol.cocktailparadise.adapters.DrinkItem;
import com.unimol.cocktailparadise.models.Drink;
import com.unimol.cocktailparadise.network.ApiService;
import com.unimol.cocktailparadise.network.DrinkService;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.network.UserService;
import com.unimol.cocktailparadise.util.Preferences;
import com.unimol.cocktailparadise.util.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDrinksActivity extends AppCompatActivity implements RecyclerViewInterface {

    private TextView noResultsTextView;
    ArrayList<Drink.drinks> responseDrinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_performed);
        this.noResultsTextView = findViewById(R.id.noResultsTextView);

        Context context = getApplicationContext();

        int userId = Preferences.getUserIdFromPreferences(UserDrinksActivity.this);

        DrinkService drinkService = RetrofitClient.getRetrofitInstanceMYSQL().create(DrinkService.class);
        Call<Drink> call = drinkService.getAllDrinks(userId);

        call.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {

                List<DrinkItem> itemList = new ArrayList<>();
                responseDrinks = response.body().getDrinks();

                if (responseDrinks != null) {
                    for (Drink.drinks drinks : responseDrinks) {
                        itemList.add(new DrinkItem(drinks.getStrDrink(), drinks.getStrCategory(), drinks.getIdDrink(), drinks.getStrDrinkThumb(),
                                drinks.getStrInstructionsIT(), drinks.getStrGlass(), drinks.getStrAlcoholic()));

                        Log.e("CIAO", "Drink name: " + drinks.getStrDrink() + "Drink id: " + drinks.getIdDrink() + "Instruzioni: \n" + drinks.getStrInstructionsIT());
                    }

                    RecyclerView recyclerView = findViewById(R.id.recyclerview);
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(new DrinkAdapter(getApplicationContext(), itemList, UserDrinksActivity.this));
                } else {

                    noResultsTextView.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
            }
        });

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(UserDrinksActivity.this, SavedDrinkDetailsActivity.class);
        intent.putExtra("idDrink", responseDrinks.get(position).getIdDrink());
        intent.putExtra("strDrink", responseDrinks.get(position).getStrDrink());
        intent.putExtra("strAlcoholic", responseDrinks.get(position).getStrAlcoholic());
        intent.putExtra("strCategory", responseDrinks.get(position).getStrCategory());
        intent.putExtra("strDrinkThumb", responseDrinks.get(position).getStrDrinkThumb());
        intent.putExtra("strGlass", responseDrinks.get(position).getStrGlass());
        intent.putExtra("strInstructionsIT", responseDrinks.get(position).getStrInstructionsIT());

        startActivity(intent);

    }
}