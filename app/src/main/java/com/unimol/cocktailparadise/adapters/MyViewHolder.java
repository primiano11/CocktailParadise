package com.unimol.cocktailparadise.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unimol.cocktailparadise.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView drinkName;
    TextView categoryName;
    ImageView imageView;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        drinkName = itemView.findViewById(R.id.drinkName);
        categoryName = itemView.findViewById(R.id.categoryName);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
