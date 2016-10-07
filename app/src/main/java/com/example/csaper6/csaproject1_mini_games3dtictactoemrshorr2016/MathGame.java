package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class MathGame extends AppCompatActivity {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double fButtonValue;
    private double sButtonValue;
    private double tButtonValue;
    private Button fButton;
    private Button sButton;
    private Button tButton;
    private int fsign;
    private int ssign;
    private int tsign;
    private String fsymbol;
    private String ssymbol;
    private String tsymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);

        fButton = (Button) findViewById(R.id.fButton);
        sButton = (Button) findViewById(R.id.sButton);
        tButton = (Button) findViewById(R.id.tButton);

        a = (int) (Math.random() * 1000);
        b = (int) (Math.random() * 1000);
        c = (int) (Math.random() * 1000);
        d = (int) (Math.random() * 1000);
        e = (int) (Math.random() * 1000);
        f = (int) (Math.random() * 1000);
        fsign = (int) (Math.random() * 4);
        ssign = (int) (Math.random() * 4);
        tsign = (int) (Math.random() * 4);

        if (fsign == 0){
            fsymbol = "+";
            fButtonValue = a + b;
        }
        else if (fsign == 1){
            fsymbol = "-";
            fButtonValue = a - b;
        }
        else{
            fsymbol = "*";
        }


    }
}
