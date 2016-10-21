package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TicTacToe extends AppCompatActivity {

    private Button ul, um, ur, ml, mm, mr, dl, dm, dr;
    private Button reset;
    private Button oWin, xWin;
    private Button score;
    private boolean player = true;
    private boolean points = false;
    private int scoreP = 0;
    private String prediction;
    //Player 1 = true & Player 2 = false

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe);

        score = (Button) findViewById(R.id.score);

        reset = (Button) findViewById(R.id.reset);

        oWin = (Button) findViewById(R.id.o);
        xWin = (Button) findViewById(R.id.x);

        ul = (Button) findViewById(R.id.ul);
        um = (Button) findViewById(R.id.um);
        ur = (Button) findViewById(R.id.ur);

        ml = (Button) findViewById(R.id.ml);
        mm = (Button) findViewById(R.id.mm);
        mr = (Button) findViewById(R.id.mr);

        dl = (Button) findViewById(R.id.dl);
        dm = (Button) findViewById(R.id.dm);
        dr = (Button) findViewById(R.id.dr);

        ul.setEnabled(false);
        um.setEnabled(false);
        ur.setEnabled(false);

        ml.setEnabled(false);
        mm.setEnabled(false);
        mr.setEnabled(false);

        dl.setEnabled(false);
        dm.setEnabled(false);
        dr.setEnabled(false);

        reset.setEnabled(false);

        oWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prediction = "O";

                ul.setEnabled(true);
                um.setEnabled(true);
                ur.setEnabled(true);

                ml.setEnabled(true);
                mm.setEnabled(true);
                mr.setEnabled(true);

                dl.setEnabled(true);
                dm.setEnabled(true);
                dr.setEnabled(true);

                reset.setEnabled(true);

                oWin.setEnabled(false);
                xWin.setEnabled(false);
            }
        });

        xWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prediction = "X";

                ul.setEnabled(true);
                um.setEnabled(true);
                ur.setEnabled(true);

                ml.setEnabled(true);
                mm.setEnabled(true);
                mr.setEnabled(true);

                dl.setEnabled(true);
                dm.setEnabled(true);
                dr.setEnabled(true);

                reset.setEnabled(true);

                xWin.setEnabled(false);
                oWin.setEnabled(false);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = false;

                ul.setText("");
                um.setText("");
                ur.setText("");

                ml.setText("");
                mm.setText("");
                mr.setText("");

                dl.setText("");
                dm.setText("");
                dr.setText("");


                ul.setEnabled(false);
                um.setEnabled(false);
                ur.setEnabled(false);

                ml.setEnabled(false);
                mm.setEnabled(false);
                mr.setEnabled(false);

                dl.setEnabled(false);
                dm.setEnabled(false);
                dr.setEnabled(false);


                reset.setEnabled(false);


                oWin.setEnabled(true);
                xWin.setEnabled(true);

            }
        });

        ul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ul.getText().equals("")) {
                    if (player) {
                        ul.setText("O");
                        player = false;
                    } else {
                        ul.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (um.getText().equals("")) {
                    if (player) {
                        um.setText("O");
                        player = false;
                    } else {
                        um.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        ur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ur.getText().equals("")) {
                    if (player) {
                        ur.setText("O");
                        player = false;
                    } else {
                        ur.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });


        ml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ml.getText().equals("")) {
                    if (player) {
                        ml.setText("O");
                        player = false;
                    } else {
                        ml.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        mm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mm.getText().equals("")) {
                    if (player) {
                        mm.setText("O");
                        player = false;
                    } else {
                        mm.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        mr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mr.getText().equals("")) {
                    if (player) {
                        mr.setText("O");
                        player = false;
                    } else {
                        mr.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });


        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dl.getText().equals("")) {
                    if (player) {
                        dl.setText("O");
                        player = false;
                    } else {
                        dl.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        dm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dm.getText().equals("")) {
                    if (player) {
                        dm.setText("O");
                        player = false;
                    } else {
                        dm.setText("X");
                        player = true;
                    }
                    check();
                }
            }
        });
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dr.getText().equals("")) {
                    if (player) {
                        dr.setText("O");
                        player = false;
                    } else {
                        dr.setText("X");
                        player = true;
                    }
                    check();
                }
            }


        });


    }

    private void check() {

        //Wins all in a row top
        if (ul.getText().equals(um.getText()) && ul.getText().equals(ur.getText()) && ul.getText() != "" && um.getText() != "" && ur.getText() != "") {
            Toast.makeText(TicTacToe.this, ul.getText() + " Wins", Toast.LENGTH_SHORT).show();
            /*ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);*/

            ml.setEnabled(false);
            mm.setEnabled(false);
            mr.setEnabled(false);

            dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);

            if (ul.getText().equals(prediction))
                points = true;
        }

        //Wins all in the middle
        else if (ml.getText().equals(mm.getText()) && ml.getText().equals(mr.getText()) && ml.getText() != "" && mm.getText() != "" && mr.getText() != "") {
            Toast.makeText(TicTacToe.this, ml.getText() + " Wins", Toast.LENGTH_SHORT).show();
            ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);

            /*ml.setEnabled(false);
            mm.setEnabled(false);
            mr.setEnabled(false);*/

            dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);

            if (ml.getText().equals(prediction))
                points = true;
        }

        //Wins all in the bottom
        else if (dl.getText().equals(dm.getText()) && dl.getText().equals(dr.getText()) && ul.getText() != "" && dm.getText() != "" && dr.getText() != "") {
            Toast.makeText(TicTacToe.this, dl.getText() + " Wins", Toast.LENGTH_SHORT).show();
            ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);

            ml.setEnabled(false);
            mm.setEnabled(false);
            mr.setEnabled(false);

            /*dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);*/

            if (dl.getText().equals(prediction))
                points = true;
        }

        //Wins down first row
        else if (ul.getText().equals(ml.getText()) && ul.getText().equals(dl.getText()) && ul.getText() != "" && ml.getText() != "" && dl.getText() != "") {
            Toast.makeText(TicTacToe.this, ul.getText() + " Wins", Toast.LENGTH_SHORT).show();
            //ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);

            //ml.setEnabled(false);
            mm.setEnabled(false);
            mr.setEnabled(false);

            //dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);

            if (ul.getText().equals(prediction))
                points = true;
        }

        //Wins down middle row
        else if (um.getText().equals(mm.getText()) && um.getText().equals(dm.getText()) && um.getText() != "" && mm.getText() != "" && dm.getText() != "") {
            Toast.makeText(TicTacToe.this, um.getText() + " Wins", Toast.LENGTH_SHORT).show();
            ul.setEnabled(false);
            //um.setEnabled(false);
            ur.setEnabled(false);

            ml.setEnabled(false);
            //mm.setEnabled(false);
            mr.setEnabled(false);

            dl.setEnabled(false);
            //dm.setEnabled(false);
            dr.setEnabled(false);

            if (um.getText().equals(prediction))
                points = true;
        }

        //Wins down right row
        else if (ur.getText().equals(mr.getText()) && ur.getText().equals(dr.getText()) && ur.getText() != "" && mr.getText() != "" && dr.getText() != "") {
            Toast.makeText(TicTacToe.this, ur.getText() + " Wins", Toast.LENGTH_SHORT).show();
            ul.setEnabled(false);
            um.setEnabled(false);
            //ur.setEnabled(false);

            ml.setEnabled(false);
            mm.setEnabled(false);
            //mr.setEnabled(false);

            dl.setEnabled(false);
            dm.setEnabled(false);
            //dr.setEnabled(false);

            if (ur.getText().equals(prediction))
                points = true;
        }

        //Wins diagonally ur
        else if (ur.getText().equals(mm.getText()) && ur.getText().equals(dl.getText()) && ur.getText() != "" && mm.getText() != "" && dl.getText() != "") {
            Toast.makeText(TicTacToe.this, ur.getText() + " Wins", Toast.LENGTH_SHORT).show();
            ul.setEnabled(false);
            um.setEnabled(false);
            //ur.setEnabled(false);

            ml.setEnabled(false);
            //mm.setEnabled(false);
            mr.setEnabled(false);

            //dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);

            if (ur.getText().equals(prediction))
                points = true;
        }

        //Wins diagonally ul
        else if (ul.getText().equals(mm.getText()) && ul.getText().equals(dr.getText()) && ul.getText() != "" && mm.getText() != "" && dr.getText() != "") {
            Toast.makeText(TicTacToe.this, ul.getText() + " Wins", Toast.LENGTH_SHORT).show();
            //ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);

            ml.setEnabled(false);
            //mm.setEnabled(false);
            mr.setEnabled(false);

            dl.setEnabled(false);
            dm.setEnabled(false);
            //dr.setEnabled(false);

            if (ul.getText().equals(prediction))
                points = true;
        }

        //Draw
        else if (ul.getText() != "" && um.getText() != "" && ur.getText() != "" &&
                ml.getText() != "" && mm.getText() != "" && mr.getText() != "" &&
                dl.getText() != "" && dm.getText() != "" && dr.getText() != "" ) {
            Toast.makeText(TicTacToe.this, "Draw", Toast.LENGTH_SHORT).show();

            ul.setEnabled(false);
            um.setEnabled(false);
            ur.setEnabled(false);

            ml.setEnabled(false);
            mm.setEnabled(false);
            mr.setEnabled(false);

            dl.setEnabled(false);
            dm.setEnabled(false);
            dr.setEnabled(false);

        }

        if (points == true)
        {
            scoreP++;

            score.setText("Score: " + scoreP);
        }
    }
}

