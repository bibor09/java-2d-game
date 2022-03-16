package main;

import screen.EndScreen;
import screen.GameScreen;
import screen.TitleScreen;
import ui_and_audio.Sound;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // Screen settings
    private int tileSize = 16*3;                                // og tilesize = 16, scale = 4
    private int screenCol = 16;
    private int screenRow = 12;
    private int screenWidth = tileSize * screenCol;
    private int screenHeight = tileSize * screenRow;
    private int gameState = 0;

    // Adding 3 screens to gp
    private TitleScreen titleScreen = new TitleScreen(this);
    private EndScreen endScreen = new EndScreen(this);
    private GameScreen gameScreen = new GameScreen(this);


    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(new Color(1,1,1));
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if(gameState == 0){
            titleScreen.draw(g2);
        }
        if(gameState == 1) {
           gameScreen.draw(g2);
        }
        if(gameState == 2){
            endScreen.draw(g2);
        }
    }

    public void update(){
        if(gameState == 1) {
            gameScreen.update();
        }
    }

    // getter & setter
    public int getTileSize() {
        return tileSize;
    }

    public int getScreenCol() {
        return screenCol;
    }

    public int getScreenRow() {
        return screenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public GameScreen getGameScreen() {
        return gameScreen;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
}
