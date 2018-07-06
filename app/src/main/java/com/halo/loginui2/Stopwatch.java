package com.halo.loginui2;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Stopwatch extends AppCompatActivity {
Button btnStart,btnPause,btnLap;
TextView txtTimer;
LinearLayout container;
Handler customHandler=new Handler();
long startTime=0L,timeInMilliseconds=0L,timeSwapBuff=0L,updateTime=0L;

Runnable updateTimerThread=new Runnable() {
    @Override
    public void run() {
         timeInMilliseconds = SystemClock.uptimeMillis()-startTime;
         updateTime=timeSwapBuff+timeInMilliseconds;
         int secs=(int)(updateTime/1000);
         int mins=secs/60;
         secs%=60;
         int milliseconds=(int)(updateTime%1000);
         txtTimer.setText(""+mins+":"+String.format("%02d",secs)+":"+String.format("%03d",milliseconds));
         customHandler.postDelayed(this,0);



    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);



btnStart=(Button)findViewById(R.id.btnStart);
btnPause=(Button)findViewById(R.id.btnStart);
btnLap=(Button)findViewById(R.id.btnLap);
txtTimer=(TextView)findViewById(R.id.timerValue);
container=(LinearLayout)findViewById(R.id.container);


btnStart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startTime=SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread,0);

    }
});






        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeSwapBuff+=timeInMilliseconds;
                customHandler.postDelayed(updateTimerThread,0);

            }
        });



        btnLap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater=(LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View addView=inflater.inflate(R.layout.row,null);
                TextView txtValue=(TextView)addView.findViewById(R.id.txtContent);
                txtValue.setText(txtTimer.getText());
                container.addView(addView);


            }
        });



    }
}
