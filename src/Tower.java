import processing.core.PApplet;

import java.util.ArrayList;


public class Tower {
    private static int x;
    private static int y;
    private int timer;


    public Tower(int x, int y){
        this.x=x;
        this.y=y;
        timer = 20;
    }
    public static int getX(){
        return x;
    }
    public static int getY(){
        return y;
    }


    public void draw (PApplet window) {
        window.fill(0, 200, 200);
        window.rect(x, y, 70, 90);
    }
}
