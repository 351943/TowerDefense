import processing.core.PApplet;


public class Bullet {
    private double x;
    private double y;
    private double ySpeed;


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
        window.rect((int)x,(int)y, 20,30);
    }

     public void update() {
         y = y + ySpeed;
    }

    public boolean collide(int tankX,int tankY, double width){
        if (((double)(tankX)+width) >= x && x>=(double)(tankX)) {
            if (y+20 >= (double)(tankY)&& y+20<(double)(tankY)+80.0) {
                return true;
            }
        }
        return false;
    }
}
