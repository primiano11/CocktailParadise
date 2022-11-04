package com.unimol.cocktailparadise.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.unimol.cocktailparadise.R;

import org.w3c.dom.Text;

public class DrinkDetailsActivity extends AppCompatActivity {

    private ImageView drinkThumbnail;
    private TextView drinkNameDetails;
    private TextView drinkCategoryDetails;
    private TextView instructionsDetails;
    private Button saveButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.unimol.cocktailparadise.R.layout.activity_drink_details);

        Intent intent = getIntent();


        this.drinkThumbnail = (ImageView) findViewById(R.id.drinkImage);
        Picasso.get().load(intent.getStringExtra("strThumb")).into(drinkThumbnail);

        this.drinkCategoryDetails = (TextView) findViewById(R.id.drinkCategoryDetails);
        drinkCategoryDetails.setText(intent.getStringExtra("strCategory"));

        this.drinkNameDetails = (TextView) findViewById(R.id.drinkNameDetails);
        drinkNameDetails.setText(intent.getStringExtra("strDrink"));

        this.instructionsDetails = (TextView) findViewById(R.id.instructionsDetails);
        instructionsDetails.setText(intent.getStringExtra("strInstructionsIT"));


    }
}