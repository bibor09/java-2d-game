package main;

import javax.swing.*;

public class GameFrame extends JFrame {
    private GamePanel gp;
    private GameController gc;

    // GameFrame constructor - creates frame, calls method startGame
    public GameFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("MyGame");
        startGame();
    }

    public void startGame(){
        // add game panel
        gp = new GamePanel();
        this.add(gp);
        this.pack();                                                        // size after panel
        setLocationRelativeTo(null);                                        // in the middle

        //  add and start game thread
        gc = new GameController(gp);
        Thread gameThread = new Thread(gc);
        gameThread.start();
    }
}
