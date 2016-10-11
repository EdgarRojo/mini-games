package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

/**
 * Created by csaper6 on 10/11/16.
 */
public class Numbers {
    private int a;
    private int b;
    private int c;

    public String generateProblem(){
        a = (int) (Math.random() * 1000);
        b = (int) (Math.random() * 1000);
        c = (int) (Math.random() * 4);
        if (c == 0){
            return Integer.toString(a) + "+" + Integer.toString(b);
        }
        else if (c == 1){
            return Integer.toString(a) + "-" + Integer.toString(b);
        }
        else if (c == 2){
            return Integer.toString(a) + "*" + Integer.toString(b);
        }
        else{
            return Integer.toString(a) + "/" + Integer.toString(b);
        }
    }

    public int generateValue(){

    }
}
