package com.halo.loginui2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ViewProfile extends AppCompatActivity {
Button btn_edit_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        btn_edit_profile=(Button) findViewById(R.id.btn_profile);


    }





    public void onClick_edit_profile(View v){
        Intent edit_profile=new Intent(this,UpdateProfile.class);
        startActivity(edit_profile);
    }
}
