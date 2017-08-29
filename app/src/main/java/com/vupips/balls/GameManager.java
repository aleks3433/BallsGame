package com.vupips.balls;


import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class GameManager {
    public static  int MAX_ENEMY_CIRCLES ;

    private MainCircle mainCircle;
    private CanvasView canvasView;
    private ArrayList<EnemyCircle> enemyCircles;
    private static int height, width;

    public GameManager(CanvasView canvasView, int h, int w) {
        this.canvasView = canvasView;
        height = h;
        width = w;
        initMainCircle();
        initEnemyCircles();
    }

    private void initEnemyCircles() {
        SimpleCircle mainCircleArea = mainCircle.getCircleArea();
        enemyCircles = new ArrayList<>();
        for (int i = 0; i < MAX_ENEMY_CIRCLES; i++) {
            EnemyCircle e;
            do {
                e = EnemyCircle.getRandomCircle();
            } while (e.isIntersect(mainCircleArea));
            enemyCircles.add(e);
        }
        calculateAndSetCircle();
    }

    private void calculateAndSetCircle() {
        for (EnemyCircle circle : enemyCircles) {circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }


    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private void initMainCircle() {
        mainCircle = new MainCircle(height / 2, width / 2);
    }


    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : enemyCircles) {
            canvasView.drawCircle(circle);
        }
    }

    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircleWhenToched(x, y);
        moveCircles();
        checkCollision();
    }

    private void checkCollision() {
        SimpleCircle simpleCircleForDel = null;
        for (EnemyCircle circle: enemyCircles) {
            if(mainCircle.isIntersect(circle)) {
                if (circle.isSmallerThan(mainCircle)){
                    mainCircle.growRadius(circle);
                    simpleCircleForDel = circle;
                    calculateAndSetCircle();
                    break;
                }else {
                    gameEnd("YOU LOSE"); return;
                }
            }
        }
        if (simpleCircleForDel != null){
            enemyCircles.remove(simpleCircleForDel);
        }
        if(enemyCircles.isEmpty()){
            gameEnd("YOU WIN");
        }
    }

    private void gameEnd(String s) {
        canvasView.showMessage(s);
        mainCircle.initRadius();
        initEnemyCircles();
        canvasView.redraw();
    }

    private void moveCircles() {
        for (EnemyCircle enemyCircle: enemyCircles) {
            enemyCircle.moveOnStop();
        }
    }
}
