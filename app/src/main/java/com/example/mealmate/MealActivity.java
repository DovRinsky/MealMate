package com.example.mealmate;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MealActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_meal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle = getIntent().getExtras();
        Meal meal = (Meal) bundle.getSerializable("meal");

        ImageView iv = findViewById(R.id.meal1);
        TextView tv_mealname = findViewById(R.id.tv_mealname);
        TextView tv_desc = findViewById(R.id.tv_desc);

        iv.setImageResource(meal.getAvatar());
        tv_mealname.setText(meal.getName());
        tv_desc.setText(meal.getDescription());
    }
}
