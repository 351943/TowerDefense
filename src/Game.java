import processing.core.PApplet;


import java.lang.reflect.Array;
import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tower> towerList;

    ArrayList<Bullet> bulletList;
    int timer;
    final static int TOWER_PLACING_MODE = 0;
    final static int NORMAL_PLAY_MODE = 1;

    int mode = TOWER_PLACING_MODE;



    public void settings() {
        size(800, 800); // set the window size
    }


    public void setup() {
// TODO: initialize game variables
        timer = 80;
        tankList = new ArrayList<Tank>();
        towerList = new ArrayList<Tower>();
        bulletList = new ArrayList<Bullet>();

    }

    public void draw() {
        background(255);
        timer--;
//road
        fill(0,0,0);
        rect(0,350,800,150);
//if timer runs out, make a new tank
        fill(100,100,0);
            System.out.println(timer);
            if(timer<=0) {
                Tank t = new Tank();
                tankList.add(t);

                /*
                //new code
                Bullet b = new Bullet(t.getX(), t.getY());
                bulletList.add(b);
                //end of new code

                 */


                timer = 150;
            }

            if(!tankList.isEmpty()){
                for (Tank tank : tankList) {
                    tank.update();
                    tank.draw(this);
                }
            }

            //create towers
            for (Tower tower: towerList){
                tower.draw(this);
                for (Bullet bullet: bulletList){
                    bullet.update();
                    bullet.draw(this,tower);

                }
            }





        }



    public void mouseReleased() {
        if(mouseY>500||mouseY<310) {
            if (mode == TOWER_PLACING_MODE) {
                Tower t = new Tower(mouseX, mouseY);
                towerList.add(t);

                Bullet b = new Bullet(t.getX(), t.getY());
                bulletList.add(b);


            }
        }
    }


        public static void main(String[] args) {
        PApplet.main("Game");
    }
}

