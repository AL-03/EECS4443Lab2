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

    ArrayList<String> aLItemTitle = new ArrayList<>();
    ArrayList<String> aLItemDescription = new ArrayList<>();

    // might not be used
    ArrayList<Integer> aLItemImage = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<String> arrayListItemTitle, ArrayList<String> arrayListItemDescription, ArrayList<Integer> arrayListItemImage)
    {
        this.aLItemTitle = arrayListItemTitle;
        this.aLItemDescription = arrayListItemDescription;
        this.aLItemImage = arrayListItemImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(aLItemTitle.get(position));
        holder.itemDescription.setText(aLItemDescription.get(position));
        holder.itemImage.setImageResource(aLItemImage.get(position));
    }

    @Override
    public int getItemCount() {
        return aLItemTitle.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemTitle, itemDescription;
        ImageView itemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDescription = itemView.findViewById(R.id.itemDescription);
            itemImage = itemView.findViewById(R.id.itemImage);

        }
    }
}
