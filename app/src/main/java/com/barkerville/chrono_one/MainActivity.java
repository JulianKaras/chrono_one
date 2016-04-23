package com.barkerville.chrono_one;

import android.os.Bundle;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button startButton;
    Button pauseButton;
    Button resetButton;
    Chronometer chronometer;
    long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button)findViewById(R.id.startButton);
        pauseButton = (Button)findViewById(R.id.pauseButton);
        resetButton = (Button)findViewById(R.id.resetButton);
        chronometer = (Chronometer)findViewById(R.id.chronometer);

        startButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.startButton:
                chronometer.setBase(SystemClock.elapsedRealtime() + time);
                chronometer.start();
                break;

            case R.id.pauseButton:
                time = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
                break;

            case R.id.resetButton:
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
                time = 0;
                break;

        }

    }
}
