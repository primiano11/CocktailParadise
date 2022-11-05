package com.unimol.cocktailparadise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.util.RecyclerViewInterface;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<DrinkItem> items;

    public DrinkAdapter(Context context, List<DrinkItem> items, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.drink_item, parent, false), recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.drinkName.setText(items.get(position).getStrDrink());
        holder.categoryName.setText(items.get(position).getStrCategory());
        //holder.imageView.setImageResource(items.get(position).getImageView());

        if (items.get(position).getStrDrinkThumb() != null) {
            Picasso.get().load(items.get(position).getStrDrinkThumb()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}