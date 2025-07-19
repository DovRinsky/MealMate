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
        db.collection("Meals").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    meals.clear();
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        String description = document.getString("Description");
                        String avatarName = document.getString("Avatar");
                        int avatarResId = getAvatarResId(avatarName);
                        meals.add(new Meal(name, avatarResId, description));
                    }
                    notifyDataSetChanged();
                } else {
                    // Handle error
                }
            }
        });
    }

    // Helper method to map avatar string to drawable resource
    private int getAvatarResId(String avatarName) {
        switch (avatarName) {
            case "meal1": return R.drawable.meal1;
            case "meal2": return R.drawable.meal2;
            case "meal3": return R.drawable.meal3;
            case "meal4": return R.drawable.meal4;
            case "meal5": return R.drawable.meal5;
            case "meal6": return R.drawable.meal6;
            case "meal7": return R.drawable.meal7;
            case "mymeal": return R.drawable.mymeal;
            default: return R.drawable.meal1; // fallback
        }

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
