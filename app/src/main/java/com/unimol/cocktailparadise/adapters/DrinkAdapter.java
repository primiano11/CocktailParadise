package com.unimol.cocktailparadise.adapters;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.Drink;

import java.util.ArrayList;
import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<MyViewHolder>  {

    Context context;
    List<DrinkItem> items;

    public DrinkAdapter(Context context, List<DrinkItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.drink_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.drinkName.setText(items.get(position).getDrinkName());
        holder.categoryName.setText(items.get(position).getCategoryName());
        //holder.imageView.setImageResource(items.get(position).getImageView());
        if(items.get(position).getImageView()!=null){
            Picasso.get().load(items.get(position).getImageView()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}