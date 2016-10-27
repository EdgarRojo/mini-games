package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MathGame extends Numbers {
    private double a;
    private double b;
    private double fButtonValue;
    private double sButtonValue;
    private double tButtonValue;
    private Button fButton;
    private Button sButton;
    private Button tButton;
    private String symbol;
    private int points;
    private TextView point;
    private Button next;
    private Intent result;
    private CountDownTimer c;
    private TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);
        result = new Intent();
        points = 0;
        timer = (TextView) findViewById(R.id.timer);
        c = new CountDownTimer(10000,1) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            }
        };
        fButton = (Button) findViewById(R.id.fButton);
        sButton = (Button) findViewById(R.id.sButton);
        tButton = (Button) findViewById(R.id.tButton);
        point = (TextView) findViewById(R.id.point);
        next = (Button) findViewById(R.id.next);

        point.setText(Integer.toString(points));

        update();

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAnswer(fButtonValue)){
                    points ++;
                }
                else{
                    points --;
                }
                point.setText(Integer.toString(points));
                disableButtons();
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAnswer(sButtonValue)){
                    points++;
                }
                else{
                    points--;
                }
                point.setText(Integer.toString(points));
                disableButtons();
            }
        });

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAnswer(tButtonValue)){
                    points++;
                }
                else{
                    points--;
                }
                point.setText(Integer.toString(points));
                disableButtons();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enableButtons();
                update();
            }
        });

    }

    private void enableButtons() {
        fButton.setEnabled(true);
        sButton.setEnabled(true);
        tButton.setEnabled(true);
    }

    private void disableButtons() {
        fButton.setEnabled(false);
        sButton.setEnabled(false);
        tButton.setEnabled(false);
    }

    private boolean checkAnswer(double d) {

        if (d >= fButtonValue && d>=sButtonValue && d>=tButtonValue){
            return true;
        }
        else {
            return false;
        }
    }

    private void update() {
        c.cancel();

        result.putExtra(MenuScreen.SCORE_EXTRA,points);
        setResult(MenuScreen.RESULT_SCORE, result);
        c = new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }
            public void onFinish() {
                finish();
            }
        }.start();
        a = generateValues() * 1.0;
        b = generateValues() * 1.0;
        symbol = generateSign();
        fButton.setText(Double.toString(a) + " " + symbol + " " + Double.toString(b));
        if (symbol.equals("+")){
            fButtonValue = a + b;
        }
        else if (symbol.equals("-")){
            fButtonValue = a - b;
        }
        else if (symbol.equals("*")){
            fButtonValue = a * b;
        }
        else{
            fButtonValue = a/b;
        }
        a = generateValues() * 1.0;
        b = generateValues() * 1.0;
        symbol = generateSign();
        sButton.setText(Double.toString(a) + " " + symbol + " " + Double.toString(b));
        if (symbol.equals("+")){
            sButtonValue = a + b;
        }
        else if (symbol.equals("-")){
            sButtonValue = a - b;
        }
        else if (symbol.equals("*")){
            sButtonValue = a * b;
        }
        else{
            sButtonValue = a/b;
        }
        a = generateValues() * 1.0;
        b = generateValues() * 1.0;
        symbol = generateSign();
        tButton.setText(Double.toString(a) + " " + symbol + " " + Double.toString(b));
        if (symbol.equals("+")){
            tButtonValue = a + b;
        }
        else if (symbol.equals("-")){
            tButtonValue = a - b;
        }
        else if (symbol.equals("*")){
            tButtonValue = a * b;
        }
        else{
            tButtonValue = a/b;
        }
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
                result.putExtra(MenuScreen.SCORE_EXTRA,points);
                setResult(MenuScreen.RESULT_SCORE, result);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
