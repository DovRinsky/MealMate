package com.example.mealmate;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MealViewHolder extends RecyclerView.ViewHolder  {

    public ImageView meal1;
    public TextView tv_mealname;
    public TextView tv_desc;
    public CardView card;

    public MealViewHolder(@NonNull View itemView) {
        super(itemView);
        this.meal1 = itemView.findViewById(R.id.meal1);
        this.tv_mealname = itemView.findViewById(R.id.tv_mealname);
        this.tv_desc = itemView.findViewById(R.id.tv_desc);
        this.card = itemView.findViewById(R.id.card);

    }
}
