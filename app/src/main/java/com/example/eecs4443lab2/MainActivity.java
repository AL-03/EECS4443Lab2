package com.example.eecs4443lab2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaring a RecyclerView variable
    RecyclerView recyclerView;

    // Declaring a RecyclerViewAdapter variable
    RecyclerViewAdapter adapter;

    // Declaring an arrayList of Item objects, which will have 15 hardcoded Item objects added to it
    ArrayList<Item> arrayListItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Instantiates the content view to refer to the main activity, which will contain the RecyclerView object
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

        // constructing a new RecyclerViewAdapter object with the arrayListItems;
        adapter = new RecyclerViewAdapter(arrayListItems);

        // Creating a LinearLayoutManager for the RecyclerView that knows to handle the Item views in a vertical manner, and is set to show that the laid out Items are not in a reverse order
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Setting the RecyclerView layout manager and adapter to be those established above
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        /*
            Hard coding 15 new Item objects that correspond to different dishes, and adding them in alphabetical order to the item arrayList.
            Each Item object has the following elements:
                The dish title,
                The associated dish image,
                The total time and difficulty per dish (this is the description shown in the RecyclerView AND in the Detailed Activity)
                The associated dish ingredients (a longer string for the Detailed Activity to display only)

            Since this is a hard-coded list, there are no null items to be displayed
        */
        arrayListItems.add(new Item("Baked Feta Pasta", R.drawable.baked_feta_pasta, "45 Mins\nEasy Difficulty","1) 2 pints (20 oz) cherry tomatoes\n2) 1/2 cup extra-virgin olive oil\n3) One 8-oz block feta cheese, drained\n4) 10 oz mezze rigatoni\n5) 1 clove garlic, finely grated\n6) 1/4 cup fresh basil leaves, thinly sliced\n7) Kosher salt, ground black pepper"));
        arrayListItems.add(new Item("Baked Salmon" , R.drawable.baked_salmon, "25 Mins\nEasy Difficulty", "1) 2 Tbsp. light brown sugar\n2) 1/2 tsp. paprika\n3) 1/2 tsp. garlic powder\n4) 1/4 tsp. cayenne pepper\n5) Kosher salt, ground black pepper\n6) 1/4 cup panko breadcrumbs\n7) 1/2 cup parsley leaves, chopped\n8) 2 Tbsp. unsalted butter, melted\n9) 1 1/2 lbs skin-on salmon fillet\n10) 1 Tbsp. Dijon"));
        arrayListItems.add(new Item("Butternut Squash Stuffed Shells" , R.drawable.butternut_squash_stuffed_shells, "1 Hr 30 Mins\nEasy Difficulty", "1) 10 oz diced butternut squash\n2) 1 small shallot, halved\n3) 1 clove garlic, unpeeled\n4) 2 Tbsp. olive oil\n5) 1/4 tsp. fresh thyme leaves, finely chopped\n6) Kosher salt, ground black pepper\n7) 30 jumbo pasta shells\n8) 1/4 cup vegetable broth\n9) 20 oz dried, chopped spinach\n10) 1 lb cream cheese, room temperature\n11) 2 cups whole-milk ricotta\n12) 2 cups grated Parmesan\n13) 2 cups heavy cream\n14) 1 cup grated mozzarella\n15) 2 Tbsp. unsalted butter"));
        arrayListItems.add(new Item("Cherry Almond Smoothie" , R.drawable.cherry_almond_smoothie, "5 Mins\nEasy Difficulty", "1) 1 banana, sliced\n2) 2 cups frozen pitted cherries\n3) 1 cup almond milk\n4) 1/2 cup low-fat yogurt\n5) 1 to 2 Tbsp. honey"));
        arrayListItems.add(new Item("Chicken Adobo" , R.drawable.chicken_adobo, "2 Hrs 50 Mins\nEasy Difficulty", "1) 2/3 cup apple cider vinegar\n2) 1/4 cup soy sauce\n3) 2 Tbsp. light brown sugar\n4) 1 tsp. whole black peppercorns\n5) Large pinch crushed red pepper\n6) 4 garlic cloves, crushed\n7) 2 bay leaves\n8) 8 chicken drumsticks (max 2 3/4 lbs)\n9) 1 scallion, thinly sliced\n10) Cooked rice, for serving"));
        arrayListItems.add(new Item("Chicken Katsu" , R.drawable.chicken_katsu, "20 Mins\nEasy Difficulty", "For sauce:\n1) 1/2 cup ketchup\n2) 3 Tbsp. Worcestershire sauce\n3) 2 Tbsp. soy sauce\nFor chicken:\n1) 1/4 cup all-purpose flour\n2) 2 large eggs, lightly beaten\n3) 1 1/2 cups panko\n4) Kosher salt, ground black pepper\n5) 2 boneless skinless chicken breasts, butterflied and cut into 4 cutlets\n6) 1 1/2 cups vegetable/canola oil\n7) 2 cups finely sliced cabbage\n8) cooked white rice, for serving\n9) 4 lemon wedges"));
        arrayListItems.add(new Item("Chicken Pot Pie" , R.drawable.chicken_pot_pie, "43 Mins\nEasy Difficulty", "1) 1 1/2 lbs chicken tenders (~10)\n2) 1/2 tsp. sweet paprika\n3) 1/2 tsp. dried sage\n4) Salt, ground black pepper\n5) 3 Tbsp. extra-virgin olive oil\n6) 1 cup frozen pearl onions\n7) 1 cup frozen peas and diced carrots\n8) 2 cloves garlic, minced\n9) 2 cups low-sodium chicken stock\n10) 1 cup heavy cream\n11) 1 store bought pie crust, unbaked and thawed if frozen\n12) 1 egg, lightly beaten"));
        arrayListItems.add(new Item("Cold Brew Coffee" , R.drawable.cold_brew_coffee, "18 Hrs 5 Mins\nEasy Difficulty", "1) 1/3 cup whole coffee beans\n2) 1 1/2 cups cold water\n3) Milk and sweetener of your choice, optional"));
        arrayListItems.add(new Item("Fettuccine Alfredo" , R.drawable.fettuccine_alfredo, "25 Mins\nEasy Difficulty", "1) 1 Tbsp. unsalted butter\n2) 1 clove garlic, minced\n3) 1 tsp. grated lemon zest\n4) 2 tsp. all-purpose flour\n5) 1 cup low-fat (2%) milk\n6) Kosher salt\n7) 2 Tbsp. low-fat cream cheese\n8) 3/4 cup grated Parmesan\n9) 3 Tbsp. chopped fresh parsley\n10) 12 oz fresh fettuccine\n11) Kosher salt, ground black pepper"));
        arrayListItems.add(new Item("French Onion Dip Cups" , R.drawable.french_onion_dip_cups, "1 Hr\nEasy Difficulty", "1) 2 Tbsp. unsalted butter\n2) 2 Tbsp. extra-virgin olive oil\n3) 2 large yellow onions, thinly sliced\n4) 2 cups shredded whole milk mozzarella\n5) 1/2 cup shredded Gruyere\n6) 1/2 cup chopped chives\n7) 1 tsp. fresh thyme leaves\n8) 1/2 tsp. garlic powder\n9) Kosher salt, ground black pepper\n10) 1/4 cup low-sodium beef broth\n11) 4 oz cream cheese\n12) 2 Tbsp. Worcestershire sauce\n13) Two 1.9-oz packages small phyllo shells"));
        arrayListItems.add(new Item("Nai Wong Bao" , R.drawable.nai_wong_bao, "5 Hrs\nIntermediate Difficulty", "For custard:\n1) 1/3 cup sweetened condensed milk\n2) 1/4 cup cornstarch\n3) 2 Tbsp. bleached all-purpose flour\n4) 2 Tbsp. confectioners' sugar\n5) 1 tsp. custard powder\n6) 1/4 tsp. kosher salt\n7) 2 large eggs\n8) 5 Tbsp. unsalted butter, cold, cut in pieces\nFor dough:\n1) 1 tsp. active dry yeast\n2) 1 1/2 cups bleached all-purpose flour\n3) 1/3 cup whole milk, room temperature\n4) 3 Tbsp. confectioners' sugar\n5) 1 1/2 tsp. baking powder\n6) 1/2 tsp. kosher salt\n7) 1 Tbsp. unsalted butter, room temperature"));
        arrayListItems.add(new Item("Pancakes" , R.drawable.pancakes, "22 Mins\nExpert Difficulty", "1) 1 1/2 cups all-purpose flour\n2) 3 Tbsp. sugar\n3) 1 Tbsp. baking powder\n4) 1/4 tsp. salt\n5) 1/8 tsp. freshly ground nutmeg\n6) 2 large eggs, room temperature\n7) 1 1/4 cups milk, room temperature\n8) 1/2 tsp. pure vanilla extract\n9) 3 Tbsp. unsalted butter"));
        arrayListItems.add(new Item("Papeta Par Eda" , R.drawable.papeta_par_eda, "45 Mins\nEasy Difficulty", "1) 4 Tbsp. vegetable oil\n2) 3 red onions, thinly sliced\n3) 1 Tbsp. peeled and grated ginger\n4) 1 - 5 thai green chiles, finely chopped\n5) 3 cloves garlic, grated\n6) 1 Tbsp. unsalted butter\n7) 3 Yukon gold potatoes, cut into ~1/8-inch sliced, soaked in water\n8) Kosher salt, ground black pepper\n9) 1/2 cup chopped cilantro\n10) 6 large eggs"));
        arrayListItems.add(new Item("Party Meatballs" , R.drawable.party_meatballs, "45 Mins\nEasy Difficulty", "1) 1 cup panko\n2) 1/4 cup whole milk\n3) 1 lb ground chuck\n4) 1 lb ground veal\n5) 1 lb ground hot Italian sausage\n6) 1/2 cup grated Parmesan\n7) 2 Tbsp. chopped parsley\n8) 1 tsp. garlic powder\n9) 1 tsp. kosher salt\n10) 1/4 tsp. grated nutmeg\n11) 2 large eggs\n12) Two 24-oz jars marinara sauce"));
        arrayListItems.add(new Item("Tortilla Breakfast Wrap" , R.drawable.tortilla_breakfast_wrap, "10 Mins\nEasy Difficulty", "1) 2 large eggs\n2) Kosher salt, ground black pepper\n3) 1 Tbsp. unsalted butter\n4) One 8-inch whole-wheat tortilla\n5) 2 slices American cheese\n6) 2 thin slices deli Black Forest ham"));


        // Notifying the adapter of the change to the Item arrayList
        adapter.notifyDataSetChanged();

    }
}