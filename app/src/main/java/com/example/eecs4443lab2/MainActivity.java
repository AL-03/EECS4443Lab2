package com.example.eecs4443lab2;

import android.media.Image;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // initializing a recyclerView object
    RecyclerView recyclerView;
    ArrayList<String> arrayListItemTitle = new ArrayList<>();
    ArrayList<String> arrayListItemDescription = new ArrayList<>();

    // might not be used
    ArrayList<Image> arrayListItemImage = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // locating the recyclerView object by ID from the activity_main.xml
        recyclerView = findViewById(R.id.recyclerView);


    }
}