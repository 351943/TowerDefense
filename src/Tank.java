import processing.core.PApplet;


public class Tank {
    private  int x;
    private int y;
    private double xSpeed;
    private double ySpeed;
    private int health;


    public Tank() {
        x = 0;
        y = 400;
        xSpeed = 2;
        ySpeed = 0;
        health = 1;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getWidth(){
        return 130;
    }

    public void damage(){
        health--;
    }

    public int getHealth(){
        return health;
    }

    public boolean isOffScreen(){
        if(x>800 ){
            return true;
        }
        return false;
    }
    public void levelUp(){
        health++;
    }

    public void draw(PApplet window) {
        window.fill(0, 230, 20);
        window.rect(x, y, 130, 80);
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
    }
}
