package com.halo.loginui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartWorkout extends AppCompatActivity {
ImageView img_cardio;
ImageView img_weights;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        img_cardio=(ImageView)findViewById(R.id.Img_cardio);
img_weights=(ImageView)findViewById(R.id.Img_weights);




        img_cardio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(StartWorkout.this, Stopwatch.class);
                startActivity(start);
            }
        });


        img_weights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_weights = new Intent(StartWorkout.this,Weights.class);
                startActivity(intent_weights);
            }
        });










    }








}
