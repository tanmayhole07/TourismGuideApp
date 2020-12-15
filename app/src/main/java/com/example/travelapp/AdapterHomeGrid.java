package com.example.travelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapp.Fragments.HomeFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterHomeGrid extends RecyclerView.Adapter<AdapterHomeGrid.MyHolder> {

//    List<String> titles;
//    List<Integer> images;
//    LayoutInflater inflater;
//    Context context;

//    public AdapterHomeGrid(List<String> titles, List<Integer> images, Context context) {
//        this.titles = titles;
//        this.images = images;
//        this.inflater = LayoutInflater.from(context);
//    }
    private Context context;
    public ArrayList<ModelHome> homeList;

    public AdapterHomeGrid(Context context, ArrayList<ModelHome> homeList) {
        this.context = context;
        this.homeList = homeList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_grid_layout ,parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        ModelHome modelHome = homeList.get(position);
        String title = modelHome.getTitle();
        String uid = modelHome.getUid();
        String gridIcon = modelHome.getGridIcon();
        String latitude = modelHome.getLatitude();
        String longitude = modelHome.getLongitude();
        String description = modelHome.getDescription();
        String timings = modelHome.getTimings();

        holder.titleTv.setText(title);


        try {
            Picasso.get().load(gridIcon).placeholder(R.drawable.loading).into(holder.gridIconIv);
        }catch (Exception e){
            holder.gridIconIv.setImageResource(R.drawable.loading);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("postUid", uid);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeList.size();
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
