package com.unimol.cocktailparadise.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.util.RecyclerViewInterface;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private final RecyclerViewInterface recyclerViewInterface;
    TextView drinkName;
    TextView categoryName;
    ImageView imageView;


    public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface ) {
        super(itemView);
        this.recyclerViewInterface = recyclerViewInterface;

        drinkName = itemView.findViewById(R.id.drinkName);
        categoryName = itemView.findViewById(R.id.categoryName);
        imageView = itemView.findViewById(R.id.imageView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MyViewHolder.this.recyclerViewInterface != null){
                    int position = getAdapterPosition();

                    if(position != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(position);
                    }
                }
            }
        });
    }
}
