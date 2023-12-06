import processing.core.PApplet;


public class Bullet {
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;


    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        xSpeed = 2;
        ySpeed = 1;
    }


    public void draw (PApplet window, Tower t){
        window.fill(250,250,250);
        window.rect((int)x,(int)y, 20,30);


    }

     public void update() {


         x = x + xSpeed;
         y = y + ySpeed;



    }



}
