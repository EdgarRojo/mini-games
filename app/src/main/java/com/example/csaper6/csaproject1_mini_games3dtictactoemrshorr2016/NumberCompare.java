package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class NumberCompare extends AppCompatActivity {

    private int side;//0 left 1 right
    private int score;
    private Button left, right;
    private TextView t;
    private TextView timer;
    private int timeLeft;
    private CountDownTimer c;
    private Intent result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_compare);
        side = 3;
        score = 0;
        c = new CountDownTimer(10000,1) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }
        };
        t = (TextView) findViewById(R.id.textScore);
        timer = (TextView) findViewById(R.id.timer);
        left = (Button) findViewById(R.id.LeftButton);
        right = (Button) findViewById(R.id.RightButton);
        result = new Intent();
        next();
    }

    @Override
    protected void onResume() {
        super.onResume();
        score = this.getSharedPreferences("compare", Context.MODE_PRIVATE).getInt("Score", 0);
    }

    public void clickRight(View view) {
        if (side == 1) {
            score++;
        } else {
            score--;
        }
        next();
    }

    public void clickLeft(View view) {
        if (side == 0) {
            score++;
        } else {
            score--;
        }
        next();
    }

    public void next() {
        result.putExtra(MenuScreen.SCORE_EXTRA,score);
        setResult(MenuScreen.RESULT_SCORE, result);

        t.setText("Score: " + score);
        c.cancel();
        c = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                end(score);
            }
        }.start();
        double num = 50E2
                ;
        long l = (long) (Math.random() * num);
        double r = (Math.random() * 50);
        int e = (int) (Math.random() * 5);
        double rr = r*(Math.pow(10,e));
        if (l == rr) {
            r++;
        } else if (l > rr) {
            side = 0;
        } else {
            side = 1;
        }
        left.setText(NumberFormat.getIntegerInstance().format(l));
        right.setText(r + " x 10^" + e);
    }
    public void end(int score){

        SharedPreferences prefs = this.getSharedPreferences("Stuffs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Score", score);
        editor.commit();
        finish();

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
