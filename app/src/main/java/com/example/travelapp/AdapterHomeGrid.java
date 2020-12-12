package com.example.travelapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapp.Fragments.HomeFragment;

import java.util.List;

public class AdapterHomeGrid extends RecyclerView.Adapter<AdapterHomeGrid.MyHolder> {

    List<String> titles;
    List<Integer> images;
    LayoutInflater inflater;
    Context context;

    public AdapterHomeGrid(List<String> titles, List<Integer> images, Context context) {
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(context);
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.home_grid_layout ,parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.titleTv.setText(titles.get(position));
        holder.gridIconIv.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView titleTv;
        ImageView gridIconIv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            gridIconIv = itemView.findViewById(R.id.gridIconIv);

        }
    }

}
