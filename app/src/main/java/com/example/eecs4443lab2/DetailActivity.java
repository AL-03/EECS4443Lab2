package com.example.eecs4443lab2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Gets the elements from activity_detail using their id's.
        Intent intent = getIntent();
        TextView descriptionBox = findViewById(R.id.descriptionBox);
        TextView ingredientBox = findViewById(R.id.ingredientBox);
        TextView titleBox = findViewById(R.id.titleBox);
        ImageView thumbnail = findViewById(R.id.thumbnail);

        //Sets each element to the provided values given by the intent.
        descriptionBox.setText(intent.getStringExtra("description"));
        ingredientBox.setText(intent.getStringExtra("ingredients"));
        titleBox.setText(intent.getStringExtra("title"));
        thumbnail.setImageResource(intent.getIntExtra("imageResId", 0));


    }
}
