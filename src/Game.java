import processing.core.PApplet;


import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tower> towerList;

    ArrayList<Bullet> bulletList;
    int timer;
    final static int TOWER_PLACING_MODE = 0;
    final static int NORMAL_PLAY_MODE = 1;
    int Health;
    int mode = TOWER_PLACING_MODE;


    public void settings() {
        size(800, 800); // set the window size
    }


    public void setup() {
// TODO: initialize game variables
        timer = 80;
        Health =5;
        tankList = new ArrayList<Tank>();
        towerList = new ArrayList<Tower>();
        bulletList = new ArrayList<Bullet>();

    }

    public void draw() {
        gameOver();
        background(255);
        timer--;
//road

        fill(0, 0, 0);
        rect(0, 350, 800, 150);
//if timer runs out, make a new tank
        fill(100, 100, 0);
        textSize(35);
        text("Your Health: "+ Health, 20, 50);
        if (timer <= 0) {
            Tank t = new Tank();
            tankList.add(t);
            if (!towerList.isEmpty()) {
                for (Tower tower : towerList) {
                    Bullet b = new Bullet(tower.getX(), tower.getY());
                    bulletList.add(b);
                    for (Bullet bullet : bulletList) {
                        bullet.update();
                        bullet.draw(this, tower);
                        //clean (duplicate shooting)
                    }
                }
            }
            timer = 150;
        }

        //update and draw tank
        if (!tankList.isEmpty()) {
            for (Tank tank : tankList) {
                tank.update();
                tank.draw(this);
            }
        }

        //tank damage and collision with bullet
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            for (int j = 0; j < tankList.size(); j++) {
                Tank tank = tankList.get(j);
                if (bullet.collide(tank.getX(),tank.getY(),tank.getWidth())){
                    tank.damage();
                    bulletList.remove(bullet);
                    if (i>=1) {
                        i--;
                    }
                    if (tank.getHealth()==0){
                        tankList.remove(tank);
                        Health++;
                        if (j>=1) {
                            j--;
                        }
                    }
                }
            }
        }
        //create towers and shoot bullets
        for (Tower tower : towerList) {
            tower.draw(this);
            for (Bullet bullet : bulletList) {
                bullet.update();
                bullet.draw(this, tower);
            }
        }

        //tank remove offscreen
        for (int i = 0; i < tankList.size(); i++) {
            Tank tank = tankList.get(i);
            if (tank.isOffScreen()){
                tankList.remove(tank);
                Health--;
            }
        }

        //tank size limit
        if (towerList.size()>5){
            mode = NORMAL_PLAY_MODE;
        }


    }

    //place tank
    public void mouseReleased() {
        if (mouseY > 500 || mouseY < 310) {
            if (mode == TOWER_PLACING_MODE) {
                Tower t = new Tower(mouseX, mouseY);
                towerList.add(t);
                Bullet b = new Bullet(t.getX(), t.getY());
                bulletList.add(b);
            }
        }
    }

    public void gameOver(){
        if(Health <=0) {
            background(100, 0, 0);
            textSize(70);
            text("Game Over", 300, 350);
        }
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

