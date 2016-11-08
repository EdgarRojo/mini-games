package com.example.csaper6.csaproject1_mini_games3dtictactoemrshorr2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class Hypno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hypno);
        GifImageView hypno = (GifImageView)findViewById(R.id.hypno);
        if(Math.random()>=.5)
            hypno.setImageResource(R.drawable.hypno);
        else
            hypno.setImageResource(R.drawable.toad);
        ((GifDrawable)hypno.getDrawable()).setLoopCount(0);
        ((GifDrawable)hypno.getDrawable()).start();
        Stopwatch s = new Stopwatch();

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
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
