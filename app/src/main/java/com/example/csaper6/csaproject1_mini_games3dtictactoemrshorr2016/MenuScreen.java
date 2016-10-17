package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import pl.droidsonroids.gif.GifImageView;

public class MenuScreen extends AppCompatActivity {

    private TextView scoreT;
    private int score =0;
    private Button compareB, tttB, ttt3B, coinB, timeB, mathB;
    public static final int RESULT_SCORE = 8745;
    public static final String SCORE_EXTRA = "CELEBRATIONTIMES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);
        scoreT = (TextView)findViewById(R.id.score);
        scoreT.setText(""+score);

        ((GifImageView)findViewById(R.id.pumpkinScore)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score+=10;
                refresh();
            }
        });

        buttonStuffs();

    }

    private void buttonStuffs() {
        compareB = (Button)findViewById(R.id.compare);
        tttB = (Button)findViewById(R.id.ttt);
        ttt3B = (Button)findViewById(R.id.ttt3);
        coinB = (Button)findViewById(R.id.coin);
        mathB = (Button)findViewById(R.id.math);
        timeB = (Button)findViewById(R.id.time);

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

            }
        });

        ttt3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        coinB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mathB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<10)
                    Toast.makeText(MenuScreen.this, "You need 10 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else {
                    Intent i = new Intent(MenuScreen.this, MathGame.class);
                    startActivityForResult(i, RESULT_SCORE);
                }
            }
        });

        timeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(score<10)
                    Toast.makeText(MenuScreen.this, "You need 10 or more pumpkins to play", Toast.LENGTH_SHORT).show();
                else{
                    //Intent i = new Intent(this, );
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("asfd", "activity finished");
        if(requestCode==RESULT_SCORE){
            score += data.getIntExtra(SCORE_EXTRA,0);
            getSharedPreferences("score",0).edit().putInt("score", score).commit();
            refresh();


        }
    }

    private void refresh() {
        scoreT.setText(""+score);
    }
}
