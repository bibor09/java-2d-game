package main;

public class GameController implements Runnable{
    private GamePanel gp;
    private int fps = 60;

    public GameController(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.0/fps;
        double lastTime = System.nanoTime();
        double currentTime, delta = 0;

        while (true) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                gp.update();
                gp.repaint();
                delta = 0;
            }
        }

    }
}
