import processing.core.PApplet;


public class Bullet {
    private int x;
    private int y;
    private int ySpeed;


    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        if (y<500) {
            ySpeed = 1;
        }
        else {
            ySpeed=-1;
        }

    }


    public void draw (PApplet window, Tower t){
        window.fill(250,250,250);
        window.rect(x,y, 20,30);
    }

     public void update() {
         y = y + ySpeed;
    }

    public boolean collide(int tankX,int tankY, double width){
        if ((tankX+width) >= x && x>=tankX) {
            if (y+20 >= (double)(tankY)&& y+20<(double)(tankY)+80.0) {
                return true;
            }
        }
        return false;
    }
}
