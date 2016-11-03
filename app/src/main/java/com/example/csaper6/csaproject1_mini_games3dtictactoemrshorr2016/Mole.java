package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Mole extends AppCompatActivity {
    private ImageView one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen;
    private ImageView[] but;
    private CountDownTimer c;
    private int i;
    private int points;
    private TextView p;
    private int t;
    private Intent result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mole);
        t = 600;

        result = new Intent();



        one = (ImageView) findViewById(R.id.one);
        two = (ImageView) findViewById(R.id.two);
        three = (ImageView) findViewById(R.id.three);
        four = (ImageView) findViewById(R.id.four);
        five = (ImageView) findViewById(R.id.five);
        six = (ImageView) findViewById(R.id.six);
        seven = (ImageView) findViewById(R.id.seven);
        eight = (ImageView) findViewById(R.id.eight);
        nine = (ImageView) findViewById(R.id.nine);
        ten = (ImageView) findViewById(R.id.ten);
        eleven = (ImageView) findViewById(R.id.eleven);
        twelve = (ImageView) findViewById(R.id.twelve);
        thirteen = (ImageView) findViewById(R.id.thirteen);
        fourteen = (ImageView) findViewById(R.id.fourteen);
        fifteen = (ImageView) findViewById(R.id.fifteen);
        p = (TextView) findViewById(R.id.p);

        but = new ImageView[]{one, two, three, four, five, six, seven, eight, nine, ten, eleven, twelve, thirteen, fourteen, fifteen};

        for(int x = 0; x<but.length; x++){
            but[x].setVisibility(View.INVISIBLE);
        }



        c = new CountDownTimer(t, 100) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                but[i].setClickable(false);
                but[i].setVisibility(View.INVISIBLE);
                i = (int) (Math.random() * but.length);
                but[i].setClickable(true);
                but[i].setVisibility(View.VISIBLE);
                if(t>=300)
                    t=(int)(t*.9);
                Log.e("asdf",""+t);
                c.start();
            }
        };



        points = 0;
        p.setText(Integer.toString(points));

        for (int b = 0; b<but.length; b++){
            but[b].setClickable(false);
        }

        for (int b = 0; b<but.length; b++){
            final int finalB = b;
            but[b].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    points++;
                    result.putExtra(MenuScreen.SCORE_EXTRA,points);
                    setResult(MenuScreen.RESULT_SCORE, result);
                    p.setText(Integer.toString(points));
                    but[finalB].setClickable(false);
                }
            });
        }

        c.start();
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
