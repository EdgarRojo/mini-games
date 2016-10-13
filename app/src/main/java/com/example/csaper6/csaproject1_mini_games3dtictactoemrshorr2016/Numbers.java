package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by csaper6 on 10/11/16.
 */
public class Numbers extends AppCompatActivity {
    private int a;
    private int b;


    public int generateValues(){
        a = (int) (Math.random() * 1000);
        return a;
    }

    public String generateSign(){
        b = (int) (Math.random() * 4);
        if (b == 0){
            return "+";
        }
        else if (b == 1){
            return "-";
        }
        else if (b == 2){
            return "*";
        }
        else{
            return "/";
        }
    }
}

