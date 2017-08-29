package com.vupips.balls;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

   static Bitmap main, enemy, food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameManager.MAX_ENEMY_CIRCLES = getIntent().getIntExtra("number", 10);
        EnemyCircle.RANDOM_SPEED = getIntent().getIntExtra("speed", 30);
        MainCircle.INIT_RADIUS = getIntent().getIntExtra("radius", 50);
        setContentView(R.layout.activity_main);
    }
}
