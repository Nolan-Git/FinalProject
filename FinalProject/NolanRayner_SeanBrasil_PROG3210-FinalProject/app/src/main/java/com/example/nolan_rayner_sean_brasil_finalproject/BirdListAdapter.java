package com.example.nolan_rayner_sean_brasil_finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdListAdapter extends RecyclerView.Adapter<BirdListAdapter.ViewHolder> {
    // variable for our array list and context
    private ArrayList<BirdModel> BirdModelAdapter;
    private Context context;
    // constructor
    public BirdListAdapter(ArrayList<BirdModel> birdModelArrayList, Context context) {
        this.BirdModelAdapter = birdModelArrayList;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
// on below line we are inflating our layout
// file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.birdlist_rows, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
// on below line we are setting data
// to our views of recycler view item.
        BirdModel modal = BirdModelAdapter.get(position);
        //holder.birdImageIV.setImageResource(modal.getImage());
        holder.birdNameTV.setText(modal.getName());
        holder.birdDescTV.setText(modal.getBirdDescription());
        holder.birdLocationTV.setText(modal.getBirdLocation());
        holder.birdStatusTV.setText(modal.getBirdStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// on below line we are calling an intent.
                Intent i = new Intent(context, UpdateBirdActivity.class);
// below we are passing all our values.
                i.putExtra("name", modal.getName());
                i.putExtra("description", modal.getBirdDescription());
                i.putExtra("location", modal.getBirdLocation());
                i.putExtra("status", modal.getBirdStatus());
// starting our activity.

                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
// returning the size of our array list
        return BirdModelAdapter.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private ImageView birdImageIV;
        private TextView birdNameTV, birdLocationTV, birdStatusTV,birdDescTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
// initializing our text views
            //birdImageIV=itemView.findViewById(R.id.idIVBirdImage);
            birdNameTV = itemView.findViewById(R.id.idTVBirdName);
            birdDescTV = itemView.findViewById(R.id.idTVBirdDescription);
            birdLocationTV = itemView.findViewById(R.id.idTVBirdLocation);
            birdStatusTV = itemView.findViewById(R.id.idTVBirdStatus);
        }

    }



}
