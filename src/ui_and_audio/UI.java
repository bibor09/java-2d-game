package ui_and_audio;

import screen.GameScreen;

import java.awt.*;

public class UI {
    private GameScreen gs;
    private boolean gameFinished = false;

    public UI(GameScreen gs){
        this.gs = gs;
    }

    public void draw(Graphics2D g2){
        drawPlayerScreen(g2);
    }

    public void drawPlayerScreen(Graphics2D g2){
        g2.setColor(new Color(0, 225, 71));
        g2.fillRect(17,7,182,36);
        g2.setFont(new Font("Arial",Font.BOLD,40));
        g2.setColor(Color.black);
        g2.drawString("LIFE: " + gs.getPlayer().getHealth(),20,40);

        g2.setColor(new Color(0, 225, 71));
        g2.fillRect(517,7,240,36);
        g2.setFont(new Font("Arial",Font.BOLD,40));
        g2.setColor(Color.black);
        g2.drawString("SCORE: " + gs.getPlayer().getScore(),520,40);

        g2.setFont(new Font("Arial",Font.BOLD,40));
        g2.setColor(Color.black);
        g2.drawString("ENEMY: " + gs.getEnemy().getHealth(),250,40);
    }

    // getter & setter
    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
}
