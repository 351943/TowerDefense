import processing.core.PApplet;


import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tower> towerList;

    ArrayList<Bullet> bulletList;
    int timer;
    int min;
    int userHealth;
    int tanksDestroyed;
    int coins;
    int tankHealth;


    public void settings() {
        size(800, 800); // set the window size
    }


    public void setup() {
// TODO: initialize game variables
        min=1;
        coins=5;
        timer = 80;
        userHealth =5;
        tankList = new ArrayList<Tank>();
        towerList = new ArrayList<Tower>();
        bulletList = new ArrayList<Bullet>();
        tanksDestroyed=0;
        tankHealth = 1;
    }

    public void draw() {
        //if game not over
        if (gameOver()==false) {
            background(255);
            timer--;
            //road
            fill(0, 0, 0);
            rect(0, 350, 800, 150);
            //if timer runs out, make a new tank
            fill(100, 100, 0);
            textSize(35);
            //display amount pf coins
            text("Your Coins: " + coins, 20, 50);
            text("Get 5 coins to add a new tank", 150,700);
            if (timer <= 0) {
                Tank t = new Tank(tankHealth);
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
                    if (bullet.collide(tank.getX(), tank.getY(), tank.getWidth())) {
                        System.out.println(tank.getHealth());
                        tank.damage();

                        bulletList.remove(bullet);
                        if (i >= 1) {
                            i--;
                        }
                        if (tank.getHealth() == 0) {
                            tankList.remove(tank);
                            tanksDestroyed++;
                            userHealth++;
                            if (j >= 1) {
                                j--;
                            }
                            coins++;
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
                if (tank.isOffScreen()) {
                    tankList.remove(tank);
                    userHealth--;
                }

            }

            if (tanksDestroyed%5==0 && tanksDestroyed> min){
                System.out.println(tanksDestroyed);
                    tankHealth++;

                System.out.println("h:" + tankHealth);

                /*
                for (Tank tank:tankList) {
                    tank.levelUp();
                }

                 */

                if (min==1){
                    min=5;
                }
                else {
                    min += 5;
                }




            }
        }

        //Game over
        else{
            background(100, 0, 0);
            textSize(60);
            text("Game Over", 130, 350);
            text("Tanks destroyed: "+tanksDestroyed,130,400);
        }

    }

    //place tank
    public void mouseReleased() {
        if (coins>=5) {
            if (mouseY > 500 || mouseY < 310) {
                Tower t = new Tower(mouseX, mouseY);
                towerList.add(t);
                Bullet b = new Bullet(t.getX(), t.getY());
                bulletList.add(b);
                coins-=5;
            }
        }
    }

    public boolean gameOver(){
        if(userHealth <=0) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}

