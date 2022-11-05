package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.DrinkResponseDTO;
import com.unimol.cocktailparadise.models.LoginDTO;
import com.unimol.cocktailparadise.network.DrinkService;
import com.unimol.cocktailparadise.network.RetrofitClient;
import com.unimol.cocktailparadise.util.Preferences;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkDetailsActivity extends AppCompatActivity {

    private ImageView drinkThumbnail;
    private TextView drinkNameDetails;
    private TextView drinkCategoryDetails;
    private TextView drinkGlassDetails;
    private TextView drinkAlcoholicDetails;
    private TextView instructionsDetails;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unimol.cocktailparadise.R.layout.activity_drink_details);

        Intent intent = getIntent();

        Log.e("alcco", getIntent().getStringExtra("strAlcoholic"));


        Log.e("categ", getIntent().getStringExtra("strCategory"));

        this.drinkThumbnail = (ImageView) findViewById(R.id.drinkImage);
        Picasso.get().load(intent.getStringExtra("strDrinkThumb")).into(drinkThumbnail);

        this.drinkCategoryDetails = (TextView) findViewById(R.id.drinkCategoryDetails);
        drinkCategoryDetails.setText(intent.getStringExtra("strCategory"));

        this.drinkGlassDetails = (TextView) findViewById(R.id.drinkGlassDetails);
        drinkGlassDetails.setText(intent.getStringExtra("strGlass"));

        this.drinkAlcoholicDetails = (TextView) findViewById(R.id.drinkAlcoholicDetails);
        drinkAlcoholicDetails.setText(intent.getStringExtra("strAlcoholic"));

        this.drinkNameDetails = (TextView) findViewById(R.id.drinkNameDetails);
        drinkNameDetails.setText(intent.getStringExtra("strDrink"));

        this.instructionsDetails = (TextView) findViewById(R.id.instructionsDetails);
        instructionsDetails.setText(intent.getStringExtra("strInstructionsIT"));

        this.saveButton = (Button) findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int userId = Preferences.getUserIdFromPreferences(DrinkDetailsActivity.this);
                int idDrink = intent.getIntExtra("idDrink", 0);
                String strDrink = intent.getStringExtra("strDrink");
                String strCategory = intent.getStringExtra("strCategory");
                String strAlcoholic = intent.getStringExtra("strAlcoholic");
                String strGlass = intent.getStringExtra("strGlass");
                String strInstructionsIT = intent.getStringExtra("strInstructionsIT");
                String strDrinkThumb = intent.getStringExtra("strDrinkThumb");


                DrinkService drinkService = RetrofitClient.getRetrofitInstanceMYSQL().create(DrinkService.class);
                Call<DrinkResponseDTO> call = drinkService.saveDrink(idDrink, strDrink, strCategory, strAlcoholic, strGlass, strInstructionsIT, userId, strDrinkThumb);

                call.enqueue(new Callback<DrinkResponseDTO>() {
                    @Override
                    public void onResponse(Call<DrinkResponseDTO> call, Response<DrinkResponseDTO> response) {

                        DrinkResponseDTO drinkResponseDTO = response.body();
                        Toast.makeText(DrinkDetailsActivity.this, drinkResponseDTO.getMessage(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DrinkResponseDTO> call, Throwable t) {

                    }
                });


            }
        });


    }
}