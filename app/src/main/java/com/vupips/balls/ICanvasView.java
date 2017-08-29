package com.vupips.balls;

/**
 * Created by Vupips on 2/4/2016.
 */
public interface ICanvasView {
    void drawCircle (SimpleCircle simpleCircle);

    void redraw();

    void showMessage(String s);
}
