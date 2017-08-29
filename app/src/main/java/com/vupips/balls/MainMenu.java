package com.vupips.balls;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {


    static EditText eTSpeed, eTRadius, eTNumbersOfBalls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        eTNumbersOfBalls = (EditText) findViewById(R.id.eTNumbersOfBalls);
        eTRadius = (EditText) findViewById(R.id.eTRadius);
        eTSpeed = (EditText) findViewById(R.id.eTSpeed);

        play();
    }

    protected static int getSpeed() {
        String s = eTSpeed.getText().toString();
        int speed = Integer.parseInt(s);
        if(speed >= 5 || speed <= 40 ){
            return speed;
        }else return 8;
    }

    protected static int getRadius() {
        String s = eTRadius.getText().toString();
        int radius = Integer.parseInt(s);
        if(radius >= 30 || radius <= 70 ){
            return radius;
        }else return 50;
    }

    protected static int getNumberOfBalls() {
        String s = eTNumbersOfBalls.getText().toString();
        int numbers = Integer.parseInt(s);
        if(numbers >= 5 || numbers <= 15 ){
            return numbers;
        }else return 10;
    }


    private void play() {
        findViewById(R.id.btnPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this, MainActivity.class);
                i.putExtra("number", getNumberOfBalls());
                i.putExtra("radius", getRadius());
                i.putExtra("speed", getSpeed());
                startActivity(i);
            }
        });
    }
}
