package com.example.eecs4443lab2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// The RecyclerViewAdapter class extends RecyclerView.Adapter with the type of this specific class's ViewHolder
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    ArrayList<Item> arrayListItems = new ArrayList<>();


    // Constructs the RecyclerViewAdapter with the fed arrayList of Item objects, which has been hardcoded in MainActivity.java
    public RecyclerViewAdapter(ArrayList<Item> arrayListItems) {
        this.arrayListItems = arrayListItems;
    }

    //
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // The view that represents each item is inflated from the created file item_layout.xml, which will be added to the parent ViewGroup
        // Keeping the attachToRoot parameter false means that the inflater will not immediately add the Item view to the parent ViewGroup
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(item);
    }

    /*
    The data attributes of the currently seen Item (title, image and description) are bound to the UI elements laid out in the item_layout.xml file.
    The correct item is referenced by its position within the arrayList of Items, which is the dataset.
    Each attribute is fetched with the getters established in the Item data model class.
    Error handling ensures null/empty texts are handled.
    */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = arrayListItems.get(position).getTitle();
        String desc = arrayListItems.get(position).getDescription();

        if (title!=null && !title.isEmpty()) {
            holder.itemTitle.setText(title);
        }
        else {
            holder.itemTitle.setText("No title");
        }

        if (desc!=null && !desc.isEmpty()) {
            holder.itemDescription.setText(desc);
        }
        else {
            holder.itemDescription.setText("No description");
        }

        holder.itemImage.setImageResource(arrayListItems.get(position).getImageID());
      
        //Checks when the user clicks on an item and changes the layout using the DetailActivity class.
        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), DetailActivity.class);

            intent.putExtra("title", arrayListItems.get(position).getTitle());
            intent.putExtra("description", arrayListItems.get(position).getDescription());
            intent.putExtra("imageResId", arrayListItems.get(position).getImageID());
            intent.putExtra("ingredients", arrayListItems.get(position).getIngredients());

            v.getContext().startActivity(intent);
        });
    }

    // returns the size of the Item arrayList, which should be 15 based on the hardcoded Item additions established in MainActivity.java
    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Establishes the two TextView objects for each item title and description found in the item_layout.xml file
        TextView itemTitle, itemDescription;

        // Establishes the ImageView object for each item image found in the item_layout.xml file
        ImageView itemImage;

        // Attaches the attributes of the Item to the correct layout object in the xml layout
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
