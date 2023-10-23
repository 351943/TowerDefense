import processing.core.PApplet;


public class Bullet {
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;


    public Bullet(){


    }



    public void draw (PApplet window){
        window.fill(0,230,20);
        window.rect(20,40, 20,30);


    }

}
