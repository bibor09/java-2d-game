package entities;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy extends Entity{
    private GamePanel gp;
    private Player player;
    private int spriteCounter = 0, spriteNum = 0;
    private boolean alive = true;

    public Enemy(GamePanel gp, Player player, int speed, int health){
        this.gp = gp;
        this.player = player;
        setSpeed(speed);
        setHealth(20);
        newEnemy();

        getEnemyImage();
        setDirection("left");
    }

    public void getEnemyImage(){
        BufferedImage[] left = new BufferedImage[3];

        for(int i=0; i<3; i++){
            try {
                left[i] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Enemy\\enemy_" + i + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        setLeft(left);
    }

    public void draw(Graphics2D g2){
        BufferedImage image = this.getLeft()[spriteNum];
        g2.drawImage(image, getX(), getY(), gp.getTileSize(),gp.getTileSize(),null);
    }

    public void update(){
        if(alive) {
            followPlayer();

            spriteCounter++;
            if (spriteCounter > 10) {
                spriteNum = (spriteNum + 1) % 3;
                spriteCounter = 0;
            }
        }
        else {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            newEnemy();
            alive = true;
        }
    }

    public void followPlayer(){
        if(player.getX() <= getX()){
            setX(getX() - getSpeed());
        }
        if(player.getX() > getX()){
            setX(getX() + getSpeed());
        }
        if(player.getY() <= getY()){
            setY(getY() - getSpeed());
        }
        if(player.getY() > getY()){
            setY(getY() + getSpeed());
        }
    }

    public void newEnemy(){
        setHealth(20);
        Random random = new Random();
        int x = random.nextInt(gp.getTileSize(), gp.getScreenWidth()-2*gp.getTileSize());
        int y = random.nextInt(gp.getTileSize(),gp.getScreenHeight()-2*gp.getTileSize());
        this.setX(x);
        this.setY(y);
    }

    // getter & setter
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
