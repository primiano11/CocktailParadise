package com.unimol.cocktailparadise.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.models.Drink;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewHolder>  {

    private ArrayList<Drink.drinks> drinkArrayList;

    public DrinkAdapter(ArrayList<Drink.drinks> drinkArrayList){
        this.drinkArrayList = drinkArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView nameTxt;
        private TextView categoryTxt;

        public MyViewHolder(final View view){
            super(view);
            nameTxt = view.findViewById(R.id.nameTxt);
            categoryTxt = view.findViewById(R.id.categoryTxt);
        }
    }


    @NonNull
    @Override
    public DrinkAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkAdapter.MyViewHolder holder, int position) {
        String name = drinkArrayList.get(position).getStrDrink();
        String category = drinkArrayList.get(position).getStrCategory();
        holder.nameTxt.setText(name);
        holder.categoryTxt.setText(category);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
