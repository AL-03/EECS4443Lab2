package com.example.eecs4443lab2;

//Declares a Java class "Item" - this is the data model
public class Item {

        // title attribute of dish Item
        private String title;

        // image associated dish Item
        private int imageID;

        // string representing total time to make as well as the difficulty of the dish Item
        private String description;

        // string representing the ingredient list of the dish Item
        private String ingredients;


        //Constructor for initialization of "Item"
        public Item(String title, int imageID, String description, String ingredients) {
            this.title = title;
            this.imageID = imageID;
            this.description = description;
            this.ingredients = ingredients;
        }

        //Getter for title
        public String getTitle() {
            return title;
        }

        //Getter for imageID that will load the image into an ImageView object
        public int getImageID() {
            return imageID;
        }

        //Getter for description
        public String getDescription() {
            return description;
        }

        //Getter for ingredients
        public String getIngredients(){
            return ingredients;
        }


}
