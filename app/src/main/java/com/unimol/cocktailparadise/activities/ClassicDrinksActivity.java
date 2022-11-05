package com.unimol.cocktailparadise.activities;

import androidx.annotation.Nullable;
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
import com.unimol.cocktailparadise.util.Preferences;
import com.unimol.cocktailparadise.util.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassicDrinksActivity extends AppCompatActivity implements RecyclerViewInterface {

    List<DrinkItem> itemList = new ArrayList<>();

    DrinkItem ginTonic = new DrinkItem(
            "Gin Tonic",
            "Cocktail",
            178365,
            "https://www.thecocktaildb.com/images/media/drink/qcgz0t1643821443.jpg",
            "Colmate un bicchiere highball di ghiaccio, versate il gin, colmate con acqua tonica e spremete uno spicchio di limone e guarnite con una fetta di limone. ",
            "Highball glass",
            "Alcoholic");


    DrinkItem margarita = new DrinkItem(
            "Margarita",
            "Ordinary Drink",
            11007,
            "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
            "Strofina il bordo del bicchiere con la fetta di lime per far aderire il sale.\n" +
                    "Avere cura di inumidire solo il bordo esterno e cospargere di sale.\n" +
                    "Il sale dovrebbe presentarsi alle labbra del bevitore e non mescolarsi mai al cocktail.\n" +
                    "Shakerare gli altri ingredienti con ghiaccio, quindi versarli delicatamente nel bicchiere.",
            "Cocktail glass",
            "Alcoholic");

    DrinkItem classOldFash = new DrinkItem(
            "Classic Old-Fashioned",
            "Ordinary Drink",
            11145,
            "https://www.thecocktaildb.com/images/media/drink/w8cxqv1582485254.jpg",
            "In un bicchiere vecchio stile, mescola il bitter e l'acqua nella zolletta di zucchero. Riempite quasi il bicchiere di cubetti di ghiaccio e aggiungete il bourbon. Servire con un bastoncino di zucchero. Guarnire con la fetta d'arancia e la ciliegia.+",
            "Old-fashioned glass",
            "Alcoholic");

    DrinkItem vodkaLemon = new DrinkItem(
            "Vodka Lemon",
            "Cocktail",
            178363,
            "https://www.thecocktaildb.com/images/media/drink/mql55h1643820632.jpg",
            "La vodka lemon si prepara direttamente in un bicchiere highball o in un tumbler grande: mettete nel bicchiere 6-7 cubetti di ghiaccio, versate la vodka, la limonata e mescolate con un bar spoon. Infine decorate con una fetta di limone e, se preferite, aggiungete qualche fogliolina di menta. Il vostro vodka lemon è pronto per essere servito.",
            "Highball glass",
            "Alcoholic");


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_performed);
        Context context = getApplicationContext();

        itemList.add(ginTonic);
        itemList.add(classOldFash);
        itemList.add(margarita);
        itemList.add(vodkaLemon);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(new DrinkAdapter(getApplicationContext(), itemList, ClassicDrinksActivity.this));
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(ClassicDrinksActivity.this, DrinkDetailsActivity.class);
        intent.putExtra("idDrink", itemList.get(position).getIdDrink());
        intent.putExtra("strDrink", itemList.get(position).getStrDrink());
        intent.putExtra("strAlcoholic", itemList.get(position).getStrAlcoholic());
        intent.putExtra("strCategory", itemList.get(position).getStrCategory());
        intent.putExtra("strDrinkThumb", itemList.get(position).getStrDrinkThumb());
        intent.putExtra("strGlass", itemList.get(position).getStrGlass());
        intent.putExtra("strInstructionsIT", itemList.get(position).getStrInstructionsIT());

        startActivity(intent);

    }
}