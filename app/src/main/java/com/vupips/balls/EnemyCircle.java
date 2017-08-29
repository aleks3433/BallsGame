package com.vupips.balls;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimpleCircle {

    public static final int FROM_RADIUS = 10;
    public static final int TO_RADIUS = 110;
    public static int RANDOM_SPEED ;
    public static final int ENEMY_COLOR = Color.RED;
    public static final int FOOD_COLOR = Color.rgb(0, 200, 0);

    private int dx;
    private int dy;

    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random r = new Random();
        int x = r.nextInt(GameManager.getWidth());
        int y = r.nextInt(GameManager.getHeight());
        int dx = 1 + r.nextInt(RANDOM_SPEED);
        int dy = 1 + r.nextInt(RANDOM_SPEED);
        int radius = FROM_RADIUS + r.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle e = new EnemyCircle(x,y,radius, dx, dy);
        return e;
    }
    protected void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan(mainCircle)){
            setColor(FOOD_COLOR);
        }else{
            setColor(ENEMY_COLOR);
        }
    }

    protected boolean isSmallerThan(SimpleCircle circle) {
        if (radius < circle.radius){
            return true;
        }
        return false;
    }

    public void moveOnStop() {
        x += dx;
        y += dy;
        checkBound();
    }

    private void checkBound() {
        if (x > GameManager.getWidth()-20 || x<0){
            dx = -dx;
        }
        if (y > GameManager.getHeight()-20 || y<0){
            dy = -dy;
        }
    }
}
