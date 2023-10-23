import processing.core.PApplet;


import java.util.ArrayList;


public class Game extends PApplet {
    // TODO: declare game variables
    ArrayList<Tank> tankList;
    ArrayList<Tank> towerList;
    int timer;


    public void settings() {
        size(800, 800); // set the window size


    }


    public void setup() {
// TODO: initialize game variables
        timer = 80;
        tankList = new ArrayList<Tank>();


/*
for (int i = 0; i < 10; i++) {
Tank t = new Tank();
tankList.add(t);
}
*/


        Tower t1 = new Tower(10,10);
        Tower t2 = new Tower(590,590);
//road
    }
    /***
     * Draws each frame to the screen. Runs automatically in a loop at frameRate frames a second.
     * tick each object (have it update itself), and draw each object
     */
    public void draw() {
        background(255);
        timer--;
//road
        fill(0,0,0);
        rect(0,350,800,150);
//if timer runs out, make a new tank
        fill(100,100,0);
        for (int i = 0; i < 5; i++) {
            System.out.println(timer);
            if(timer<=0) {
                Tank t = new Tank();
                tankList.add(t);
                timer=80;


            }
            if(!tankList.isEmpty()){
                for (Tank tank : tankList) {
                    tank.update();
                    tank.draw(this);
                }
            }
        }


//update all the tanks
    }


    public static void main(String[] args) {
        PApplet.main("Game");
    }
}


