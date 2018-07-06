package com.halo.loginui2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private static  final int ERROR_DIALOG_REQUEST=9001;
    GridLayout MainGrid;
    ImageView btn_start,btn_maps,btn_history,btn_profile,img_settings,img_exit;
   private Button btn_exit;

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mainpage);

        btn_exit = (Button) findViewById(R.id.btn_exit);

img_exit=(ImageView)findViewById(R.id.Img_exit);


        img_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Gym 94124");

                alertDialogBuilder
                        .setMessage("Exit Application")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                MainActivity.this.finish();
                            }
                        })


                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();




            }

        });








        btn_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Gym 94124");

                alertDialogBuilder
                        .setMessage("Exit Application")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // if this button is clicked, close
                                // current activity
                                MainActivity.this.finish();
                            }
                        })


                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();




            }

        });











        if(isServiceOK()){
            init();

        }




        img_settings=(ImageView)findViewById(R.id.Img_Settings);

        img_exit=(ImageView)findViewById(R.id.Img_exit);





        btn_profile = (ImageView) findViewById(R.id.Img_Profile);
        btn_start=(ImageView)findViewById(R.id.Img_start_workout);

        btn_history=(ImageView)findViewById(R.id.Img_workout_history);





        img_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(MainActivity.this, Settings.class);
                startActivity(settings);
            }
        });




        btn_profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent profile = new Intent(MainActivity.this, ViewProfile.class);
                    startActivity(profile);
                }
            });


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(MainActivity.this, StartWorkout.class);
                startActivity(start);
            }
        });



        btn_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent history = new Intent(MainActivity.this, WorkoutHistory.class);
                startActivity(history);
            }
        });




        }

    private void init() {
      Button txt_gym=(Button)findViewById(R.id.txt_gym);
        btn_maps=(ImageView)findViewById(R.id.Img_Maps);
        btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gym = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(gym);
            }
        });
      txt_gym.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent View_Map=new Intent(MainActivity.this,MapsActivity.class);
              startActivity(View_Map);

          }
      });
    }

    public boolean isServiceOK(){
        Log.d(TAG,"isServicesOK:check google version");
        int available= GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if(available== ConnectionResult.SUCCESS){
            //make app requests
Log.d(TAG,"isServicesOK:services is working");
return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //resolve error
            Log.d(TAG,"isServicesOK:fixable");
            Dialog dialog=GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this,available,ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this,"isServicesOK:Cannot make map requests",Toast.LENGTH_SHORT).show();
        }
        return false;
    }



























    public void Click_Start(View v){
        Intent Click_Start=new Intent(this,StartWorkout.class);
        startActivity(Click_Start);
    }



    public void Click_Gym(View v){
        Intent Click_Gym=new Intent(this,MapsActivity.class);
        startActivity(Click_Gym);
    }


    public void Click_History(View v){
        Intent Click_History=new Intent(this,WorkoutHistory.class);
        startActivity(Click_History);
    }


    public void Click_Profile(View v){
        Intent Click_Profile=new Intent(this,ViewProfile.class);
        startActivity(Click_Profile);
    }







}
