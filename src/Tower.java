import processing.core.PApplet;

import java.util.ArrayList;


public class Tower {
    private int x;
    private int y;
    private int timer;


    public Tower(int x, int y){
        this.x=x;
        this.y=y;
        timer = 20;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }


    public void draw (PApplet window) {
//print x
        window.fill(0, 200, 200);
        window.rect(x, y, 30, 40);
     /*   for (Bullet bullet: bulletList){
            bullet.update();
            bullet.draw(this);
        }
      */
    }
}
