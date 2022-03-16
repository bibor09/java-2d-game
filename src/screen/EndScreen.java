package screen;

import main.GamePanel;
import ui_and_audio.Sound;

import java.awt.*;

public class EndScreen {
    private GamePanel gp;
    private Sound sound = new Sound();

    public EndScreen(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        g2.setFont(new Font("Arial",Font.BOLD,80));
        g2.setColor(new Color(87, 86, 86));
        g2.drawString("GAME OVER",gp.getScreenWidth()/2-250,gp.getScreenHeight()/2-50);

        g2.setFont(new Font("Arial",Font.PLAIN,20));
        g2.setColor(new Color(154, 154, 154));
        g2.drawString("Total score: "+gp.getGameScreen().getPlayer().getScore(),gp.getScreenWidth()/2-70,gp.getScreenHeight()/2+30);

        g2.setFont(new Font("Arial",Font.ITALIC,40));
        g2.setColor(new Color(154, 154, 154));
        g2.drawString("ENTER: back to title screen",gp.getScreenWidth()/2-240,gp.getScreenHeight()/2+100);
    }
}
