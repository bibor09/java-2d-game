package screen;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleScreen {
    private GamePanel gp;

    public TitleScreen(GamePanel gp){
        this.gp = gp;
    }

    public void draw(Graphics2D g2){
        // title
        g2.setFont(new Font("Arial",Font.BOLD,80));
        g2.setColor(new Color(87, 86, 86));
        g2.drawString("LAB ACCIDENT",gp.getScreenWidth()/2-295,gp.getScreenHeight()/2-100-5);
        g2.setFont(new Font("Arial",Font.BOLD,80));
        g2.setColor(new Color(97, 234, 146));
        g2.drawString("LAB ACCIDENT",gp.getScreenWidth()/2-300,gp.getScreenHeight()/2-100);

        // picture
        try {
            BufferedImage playerIcon = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\PLAYER.png"));
            g2.drawImage(playerIcon,gp.getScreenWidth()/2-100,gp.getScreenHeight()/2-70,gp.getTileSize()*3,gp.getTileSize()*3,null);
        } catch (IOException e) {
            e.printStackTrace();
        }


        g2.setFont(new Font("Arial",Font.ITALIC,40));
        g2.setColor(new Color(97, 234, 146));
        g2.drawString("Press ENTER to play",gp.getScreenWidth()/2-200,gp.getScreenHeight()/2+150);
    }
}
