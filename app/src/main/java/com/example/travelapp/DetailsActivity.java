package com.example.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    private String postUid;

    private ImageView postImageIv;
    private TextView titleTv, descriptionTv, timingsTv;
    private String latitude, longitude;
    private ImageButton mapBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        postUid = getIntent().getStringExtra("postUid");
        firebaseAuth = FirebaseAuth.getInstance();

        postImageIv = findViewById(R.id.postImageIv);
        titleTv = findViewById(R.id.titleTv);
        descriptionTv = findViewById(R.id.descriptionTv);
        timingsTv = findViewById(R.id.timingsTv);
        mapBtn = findViewById(R.id.mapBtn);


        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenMap();
            }
        });

        loadPostInfo();
    }

    private void loadPostInfo() {

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Home");
        ref.child(postUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String title = ""+snapshot.child("Title").getValue();
                String gridIcon = ""+snapshot.child("gridIcon").getValue();
                String description = ""+snapshot.child("description").getValue();
                latitude = ""+snapshot.child("latitude").getValue();
                longitude = ""+snapshot.child("longitude").getValue();
                String timings = ""+snapshot.child("timings").getValue();

                titleTv.setText(title);
                descriptionTv.setText(description);
                timingsTv.setText(timings);

                try {
                    Picasso.get().load(gridIcon).into(postImageIv);
                }catch (Exception e){

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void OpenMap() {
        String address = "https://maps.google.com/maps?saar=" + latitude + "," + longitude + "&daddr=" + latitude + "," + longitude;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}