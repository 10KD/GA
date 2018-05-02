import processing.core.PApplet;
import shapes.Thing;

public class MainApp extends PApplet {

    public static void main (String[] args){
        PApplet.main("MainApp", args);
    }

    Thing myRectangle;

    public void settings(){
        size(800, 600);
    }

    public void setup(){
        background(255);
        myRectangle = new Thing(this);
    }

    public void draw(){
        stroke(0);
        fill(255, 0, 255);
        ellipse(width/2, height/2, 100, 100);
        myRectangle.draw();
    }

    private boolean isRunning = true;

    public void gameLoop()
    {
        while(isRunning)
        {
            gameLogic();
            render();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
