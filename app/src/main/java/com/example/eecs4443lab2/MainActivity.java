package com.example.eecs4443lab2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        //get ids for title, image, and description
        titleTextView=findViewById(R.id.titleTextView);
        imageView=findViewById(R.id.imageView);
        descriptionTextView=findViewById(R.id.descriptionTextView);
        ingredientsTextView=findViewById(R.id.ingredientsTextView);

        //used to access data through activities
        Intent intent=getIntent();

        //get extended data from the intent for title, image, and description
        String title=intent.getStringExtra("title");
        int imageReference=intent.getIntExtra("imageReference",0);
        String description=intent.getStringExtra("description");
        String ingredients=intent.getStringExtra("ingredients");

        //Error Handling
        //No title: If no title, display "No title"
        if(title!=null && !title.isEmpty()){
            titleTextView.setText(title);
        }
        else{
            titleTextView.setText("No Title");
        }

        //No image: If no image, give a default "placeholder" image
        if(imageReference!=0){
            imageView.setImageResource(imageReference);
        }
        else{
            imageView.setImageResource(R.drawable.placeholder_image);
        }

        //No description: If no description, display "No description"
        if(description!=null && !description.isEmpty()){
            descriptionTextView.setText(description);
        }
        else{
            descriptionTextView.setText("No description");
        }

        if(ingredients!=null && !ingredients.isEmpty()){
            ingredientsTextView.setText(ingredients);
        }
        else{
            ingredientsTextView.setText("No ingredients");
        }

        });
    }
    //Declares a Java class "Item"
    public class Item {
        private String title;
        private int imageReference;
        private String description;
        private String ingredients;


        //Constructor for initialization of "Item"
        public Item(String title, int imageReference, String description, String ingredients) {
            this.title = title;
            this.imageReference = imageReference;
            this.description = description;
            this.ingredients = ingredients;
        }

        //Getter for title
        public String getTitle() {
            return title;
        }

        //Getter for imageReference
        public int getImageReference() {
            return imageReference;
        }

        //Getter for description
        public String getDescription() {
            return description;
        }

        //Getter for ingredients
        public String getIngredients(){
            return ingredients;
        }

        public void setTitle(){
            this.title=title;
        }
        public void setImageReference(){
            this.imageReference=imageReference;
        }
        public void setDescription(){
            this.description=description;
        }
        public void setIngredients(){
            this.ingredients=ingredients;
        }

    }

}