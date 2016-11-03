package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MenuScreen extends AppCompatActivity {

    private TextView scoreT;
    private int score ;
    private Button compareB, tttB, coinB,wackAMoleB, mathB, stopwatchB;
    public static final int RESULT_SCORE = 8745;
    public static final String SCORE_EXTRA = "CELEBRATIONTIMES";
    private GifImageView pumpkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        score = this.getSharedPreferences("main", Context.MODE_PRIVATE).getInt("Score", 0);
        scoreT = (TextView)findViewById(R.id.score);
        scoreT.setText(""+score);
        pumpkin = (GifImageView)findViewById(R.id.pumpkinScore);
        pumpkin.setImageResource(R.drawable.coinscore);
        ((GifDrawable)pumpkin.getDrawable()).start();
        ((GifDrawable)pumpkin.getDrawable()).setSpeed(2f);
        ((GifDrawable)pumpkin.getDrawable()).setLoopCount(0);
        pumpkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=10;
                refresh();
                startActivity(new Intent(MenuScreen.this, Hypno.class));
            }
        });

        buttonStuffs();

    }



    private void buttonStuffs() {
        compareB = (Button)findViewById(R.id.compare);
        tttB = (Button)findViewById(R.id.ttt);
        coinB = (Button)findViewById(R.id.coin);
        mathB = (Button)findViewById(R.id.math);
        wackAMoleB = (Button)findViewById(R.id.mole);
        stopwatchB = (Button)findViewById(R.id.stopwatch);

        compareB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuScreen.this, NumberCompare.class);
                startActivityForResult(i,RESULT_SCORE);
            }
        });

        tttB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<20)
                    Toast.makeText(MenuScreen.this, "You need 20 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, TicTacToe.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });

        coinB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<15)
                    Toast.makeText(MenuScreen.this, "You need 15 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, CoinFlip.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });

        mathB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<5)
                    Toast.makeText(MenuScreen.this, "You need 5 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, MathGame.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });

        wackAMoleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<20)
                    Toast.makeText(MenuScreen.this, "You need 20 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, Mole.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });
        stopwatchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<10)
                    Toast.makeText(MenuScreen.this, "You need 10 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, Stopwatch.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("asfd", "activity finished");
        if(requestCode==RESULT_SCORE){
            this.score += data.getIntExtra(SCORE_EXTRA,0);
            getSharedPreferences("score",0).edit().putInt("score", score).commit();
            refresh();
        }
    }

    private void exit(){
        SharedPreferences prefs = this.getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Score", score);
        finish();
    }
    private void refresh() {
        scoreT.setText(""+score);
    }
}
