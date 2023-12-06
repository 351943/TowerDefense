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
    }
    public int getX(){
        return x;
    }
    public  boolean outOfBounds(){
        if (x>800){
            return true;
        }
        return false;
    }

    public int getY(){
        return y;
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
