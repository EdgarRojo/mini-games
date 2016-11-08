package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class CoinFlip extends AppCompatActivity {

    private Intent result;
    private GifImageView vid;
    private Button flip;
    private TextView scoreT;
    private int score=0;
    private int guess;
    private TextView guessT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_flip);
        result = new Intent();

        flip = (Button)findViewById(R.id.flipB);
        vid = (GifImageView)findViewById(R.id.video);
        scoreT = (TextView)findViewById(R.id.score);
        guessT = (TextView)findViewById(R.id.guess);

        Log.e("asdf", "setting vid path...");
        //vid.setBackgroundResource(R.drawable.coin0);
        vid.setImageResource(R.drawable.coin0);
        Log.e("asdf","vid path set");
        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flip();
            }
        });
    }

    private void flip() {
        final int val = (int) (Math.random()*1.5);
        if(val==0)
            vid.setImageResource(R.drawable.cointo0);
        else
            vid.setImageResource(R.drawable.cointo1);

        ((GifDrawable)vid.getDrawable()).pause();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Guess the flip.");

        builder.setPositiveButton("0", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                guess = 0;
                refresh(val);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("1", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                guess = 1;
                refresh(val);
                dialog.dismiss();
            }
        });

        builder.show();

    }

    private void refresh(int val){
        if(val==guess)
            score++;
        else
            score--;
        result.putExtra(MenuScreen.SCORE_EXTRA,score);
        setResult(MenuScreen.RESULT_SCORE, result);
        ((GifDrawable)vid.getDrawable()).start();
        Log.e("asdf","Val = "+val+", Guess = "+guess);


        guessT.setText("guess: "+val);
        ((GifDrawable)vid.getDrawable()).addAnimationListener(new AnimationListener() {
            @Override
            public void onAnimationCompleted(int loopNumber) {
                ((GifDrawable)vid.getDrawable()).stop();
                scoreT.setText("Score: "+score);
                Vibrator v = (Vibrator) CoinFlip.this.getSystemService(Context.VIBRATOR_SERVICE);
                // Vibrate for 500 milliseconds
                v.vibrate(500);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.quit:
                result.putExtra(MenuScreen.SCORE_EXTRA,score);
                setResult(MenuScreen.RESULT_SCORE, result);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
