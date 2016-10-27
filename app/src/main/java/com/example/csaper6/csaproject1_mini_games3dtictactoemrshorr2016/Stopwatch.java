package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class Stopwatch extends AppCompatActivity {

    private Chronometer chronometer;
    private long mLastStopTime = 0;
    private TextView point;
    private int points;

    int min = (int)(Math.random()*0);
    int sec = (int)(Math.random()*0);

    private Button time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        point = (TextView) findViewById(R.id.point);
        points = 0;

        time = (Button) (findViewById(R.id.time));
        time.setText(String.format("%02d",min) + ":" + String.format("%02d", sec));


    }

    public void startChronometer(View view) {
        if ( mLastStopTime == 0 ) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            //chronometer.setVisibility(View.INVISIBLE);
        }
        else
        {
            long intervalOnPause = (SystemClock.elapsedRealtime() - mLastStopTime);
            chronometer.setBase( chronometer.getBase() + intervalOnPause );
        }

        restart();

        chronometer.setVisibility(View.INVISIBLE);
        chronometer.start();
    }

    private void restart() {
        sec += (int)(Math.random()*60);
        min += sec/60;
        sec = sec%60;
        time.setText(String.format("%02d",min) + ":" + String.format("%02d", sec));

    }

    public void stopChronometer(View view)
    {
        chronometer.stop();

        if(chronometer.getText().equals(time.getText())) {
            Log.e("asdf", "yay");
            points++;
            point.setText(Integer.toString(points));
        }
        chronometer.setVisibility(View.VISIBLE);

        mLastStopTime = SystemClock.elapsedRealtime();
    }

}