package com.halo.loginui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;







public class Settings extends AppCompatActivity {
    ImageView img_change_language,img_return_home,img_update_profile;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);




        img_change_language=(ImageView)findViewById(R.id.Img_change_language);
img_update_profile=(ImageView)findViewById(R.id.Img_update_profile);
        img_return_home=(ImageView)findViewById(R.id.Img_home);




        img_change_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(Settings.this, ChangeLanguage.class);
                startActivity(settings);
            }
        });






        img_update_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(Settings.this, UpdateProfile.class);
                startActivity(settings);
            }
        });


        img_return_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(Settings.this, MainActivity.class);
                startActivity(settings);
            }
        });




    }








}
