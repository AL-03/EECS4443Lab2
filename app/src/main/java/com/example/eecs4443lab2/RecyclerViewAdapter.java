package com.example.eecs4443lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    /*
    ArrayList<String> aLItemTitle = new ArrayList<>();
    ArrayList<String> aLItemDescription = new ArrayList<>();

    // might not be used
    ArrayList<Integer> aLItemImage = new ArrayList<>();
    */
    ArrayList<Item> arrayListItems = new ArrayList<>();

    /*
    public RecyclerViewAdapter(ArrayList<String> arrayListItemTitle, ArrayList<String> arrayListItemDescription, ArrayList<Integer> arrayListItemImage)
    {
        this.aLItemTitle = arrayListItemTitle;
        this.aLItemDescription = arrayListItemDescription;
        this.aLItemImage = arrayListItemImage;
    }

     */

    public RecyclerViewAdapter(ArrayList<Item> arrayListItems) {
        this.arrayListItems = arrayListItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        /*
        holder.itemTitle.setText(aLItemTitle.get(position));
        holder.itemDescription.setText(aLItemDescription.get(position));
        holder.itemImage.setImageResource(aLItemImage.get(position));
        */
        holder.itemTitle.setText(arrayListItems.get(position).getTitle());
        holder.itemImage.setImageResource(arrayListItems.get(position).getImageID());
        holder.itemDescription.setText(arrayListItems.get(position).getDescription());
        holder.itemIngredients.setText(arrayListItems.get(position).getIngredients());
    }

    @Override
    public int getItemCount() {
        return arrayListItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle, itemDescription, itemIngredients;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemImage = itemView.findViewById(R.id.itemImage);

            // goes with detailed activity
            //itemIngredients = itemView.findViewById(R.id.itemIngredients);

        }
    }
}
