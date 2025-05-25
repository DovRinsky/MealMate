package com.example.mealmate;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MealsAdapter extends RecyclerView.Adapter<MealViewHolder> {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private List<Meal> meals;

    public MealsAdapter() {
        meals = new ArrayList<>();
        meals.add(new Meal("Chicken Taco", R.drawable.meal7,"Grilled chicken tacos loaded with fresh lettuce, tomatoes, red onions, cilantro, and crunchy nuts in soft tortillas. (434 Cal)"));
        meals.add(new Meal("Stir-Fry Noodles",R.drawable.meal2,"Tender chicken, and crisp vegetables, tossed in a savory sauce and garnished with fresh herbs. (380 Cal)"));
        meals.add(new Meal("Tomato Spaghetti",R.drawable.meal3,"A classic spaghetti dish with rich tomato sauce, garnished with fresh herbs and peppercorns. (300 Cal)"));
        meals.add(new Meal("Fresh Caesar Salad",R.drawable.meal4,"A fresh Caesar salad with crispy bacon, cherry tomatoes, parmesan shavings, and a drizzle of balsamic glaze. (350 Cal)"));
        meals.add(new Meal("Truffle Rigatoni Pasta",R.drawable.meal5,"A creamy truffle rigatoni pasta, garnished with fresh parsley for a rich and aromatic flavor. (234 Cal)"));
        meals.add(new Meal("Veggie Bruschetta",R.drawable.meal6,"A crisp bruschetta topped with cherry tomatoes, yellow peppers, fresh herbs, and a drizzle of olive oil. (180 Cal)"));


    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.meal,parent,false);
        MealViewHolder viewHolder = new MealViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = meals.get(position);
        holder.tv_mealname.setText(meal.getName());
        holder.tv_desc.setText(meal.getDescription());
        holder.meal1.setImageResource(meal.getAvatar());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MealActivity.class);;
                intent.putExtra("meal",meal);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return meals.size();
    }
}
