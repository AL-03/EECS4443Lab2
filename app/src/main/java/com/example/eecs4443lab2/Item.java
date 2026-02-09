package com.example.eecs4443lab2;

//Declares a Java class "Item" - this is the data model
public class Item {
        private String title;
        private int imageID;
        private String description;
        private String ingredients;


        //Constructor for initialization of "Item"
        public Item(String title, int imageID, String description, String ingredients) {
            this.title = title;
            this.imageID = imageID;
            this.description = description;
            this.ingredients = ingredients;
        }

        //Getter for title that will be displayed in a TextView object
        public String getTitle() {
            return title;
        }

        //Getter for imageID that will load the image into an ImageView object
        public int getImageID() {
            return imageID;
        }

        //Getter for description that will be displayed in a TextView object
        public String getDescription() {
            return description;
        }

        //Getter for ingredients that will be displayed in a TextView object
        public String getIngredients(){
            return ingredients;
        }


}
