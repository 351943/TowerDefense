import processing.core.PApplet;

import java.util.ArrayList;


public class Tower {
    private int x;
    private int y;
    private int timer;
    ArrayList<Bullet> bulletList;


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


    public void draw (PApplet window){
//print x
        timer--;
        if(timer<=0) {
            Bullet b = new Bullet(getX(),getY());
            bulletList.add(b);
            timer=10;
        }
        window.fill(0,230,20);
        window.rect(20,40, 20,30);
        for (Bullet bullet: bulletList){
            bullet.update();
            bullet.draw(this);
        }
    }

}
