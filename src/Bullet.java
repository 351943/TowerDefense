import processing.core.PApplet;


public class Bullet {
    private int x;
    private int y;


    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
    }


    public void draw (PApplet window){
        window.fill(0,230,20);
        window.rect(20,40, 20,30);


    }
    public void update(Tank) {
        int xDiff = Tank.getX() - x;
        int yDiff = Tank.getY() - y;
        x = x + xDiff / 10;
        y = y + yDiff / 10;
    }


}
