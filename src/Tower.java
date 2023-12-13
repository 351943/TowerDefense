import processing.core.PApplet;

import java.util.ArrayList;


public class Tower {
    private int x;
    private int y;

    public Tower(int x, int y){
        this.x=x;
        this.y=y;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    public void draw (PApplet window) {
        window.fill(0, 200, 200);
        window.rect(x, y, 70, 90);
    }
}
