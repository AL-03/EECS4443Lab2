package com.example.eecs4443lab2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // initializing a recyclerView object
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<String> arrayListItemTitle = new ArrayList<>();
    ArrayList<String> arrayListItemDescription = new ArrayList<>();

    // might not be used
    ArrayList<Integer> arrayListItemImage = new ArrayList<Integer>();

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
        adapter = new RecyclerViewAdapter(arrayListItemTitle, arrayListItemDescription, arrayListItemImage);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        // hard coded item titles
        arrayListItemTitle.add("Baked Feta Pasta");                     //1
        arrayListItemTitle.add("Baked Salmon");                         //2
        arrayListItemTitle.add("Butternut Squash Stuffed Shells");      //3
        arrayListItemTitle.add("Cherry Almond Smoothie");               //4
        arrayListItemTitle.add("Chicken Adobo");                        //5
        arrayListItemTitle.add("Chicken Katsu");                        //6
        arrayListItemTitle.add("Chicken Pot Pie");                      //7
        arrayListItemTitle.add("Cold Brew Coffee");                     //8
        arrayListItemTitle.add("Fetuccine Alfredo");                    //9
        arrayListItemTitle.add("French Onion Dip Cups");                //10
        arrayListItemTitle.add("Nai Wong Bao");                         //11
        arrayListItemTitle.add("Pancakes");                             //12
        arrayListItemTitle.add("Papeta Par Eda");                       //13
        arrayListItemTitle.add("Party Meatballs");                      //14
        arrayListItemTitle.add("Tortilla Breakfast Wrap");              //15


        arrayListItemDescription.add("45 Mins\nEasy Difficulty");
        arrayListItemDescription.add("25 Mins\nEasy Difficulty");
        arrayListItemDescription.add("1 Hr 30 Mins\nEasy Difficulty");
        arrayListItemDescription.add("5 Mins\nEasy Difficulty");
        arrayListItemDescription.add("2 Hrs 50 Mins\nEasy Difficulty");
        arrayListItemDescription.add("20 Mins\nEasy Difficulty");
        arrayListItemDescription.add("43 Mins\nEasy Difficulty");
        arrayListItemDescription.add("18 Hrs 5 Mins\nEasy Difficulty");
        arrayListItemDescription.add("25 Mins\nEasy Difficulty");
        arrayListItemDescription.add("1 Hr\nEasy Difficulty");
        arrayListItemDescription.add("5 Hrs\nIntermediate Difficulty");
        arrayListItemDescription.add("22 Mins\nEasy Difficulty");
        arrayListItemDescription.add("45 Mins\nEasy Difficulty");
        arrayListItemDescription.add("45 Mins\nEasy Difficulty");
        arrayListItemDescription.add("10 Mins\nEasy Difficulty");

        arrayListItemImage.add(R.drawable.baked_feta_pasta);
        arrayListItemImage.add(R.drawable.baked_salmon);
        arrayListItemImage.add(R.drawable.butternut_squash_stuffed_shells);
        arrayListItemImage.add(R.drawable.cherry_almond_smoothie);
        arrayListItemImage.add(R.drawable.chicken_adobo);
        arrayListItemImage.add(R.drawable.chicken_katsu);
        arrayListItemImage.add(R.drawable.chicken_pot_pie);
        arrayListItemImage.add(R.drawable.cold_brew_coffee);
        arrayListItemImage.add(R.drawable.fetuccine_alfredo);
        arrayListItemImage.add(R.drawable.french_onion_dip_cups);
        arrayListItemImage.add(R.drawable.nai_wong_bao);
        arrayListItemImage.add(R.drawable.pancakes);
        arrayListItemImage.add(R.drawable.papeta_par_eda);
        arrayListItemImage.add(R.drawable.party_meatballs);
        arrayListItemImage.add(R.drawable.tortilla_breakfast_wrap);

        adapter.notifyDataSetChanged();

    }
}