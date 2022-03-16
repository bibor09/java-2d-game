package entities;

import mechanics.KeyHandler;
import main.GamePanel;
import ui_and_audio.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.abs;

public class Player extends Entity {
    private GamePanel gp;
    private KeyHandler keyH;
    private Enemy enemy;
    private Sound sound = new Sound();
    private int score = 0;
    private int spriteCounter = 0, spriteNum = 0, timeCounter = 0, timeCounter2 = 0;

    public Player(int x, int y, int speed, int health, GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setX(x);
        setY(y);
        setSpeed(speed);
        setHealth(health);

        getPlayerImage();
        setDirection("down");                                                       // set default direction
    }

    public void getPlayerImage(){
        BufferedImage[] auxUp = new BufferedImage[4];
        BufferedImage[] auxDown = new BufferedImage[4];
        BufferedImage[] auxLeft = new BufferedImage[4];
        BufferedImage[] auxRight = new BufferedImage[4];
        BufferedImage[] auxAttack = new BufferedImage[1];

        try{
            for(int i=0; i<4; i++){
                auxUp[i] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\playerup_" + i + ".png"));
                auxDown[i] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\playerdown_" + i + ".png"));
                auxLeft[i] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\playerleft_" + i + ".png"));
                auxRight[i] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\playerright_" + i + ".png"));
            }
            auxAttack[0] = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Player\\attack_0.png"));

            setUp(auxUp); setDown(auxDown); setLeft(auxLeft); setRight(auxRight); setAttack(auxAttack);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2, int tileSize){
        BufferedImage image = this.getDown()[spriteNum];

        switch (direction){
            case "up":
                image = getUp()[spriteNum];
                break;
            case "down":
                image = getDown()[spriteNum];
                break;
            case "left":
                image = getLeft()[spriteNum];
                break;
            case "right":
                image = getRight()[spriteNum];
                break;
            case "attack":
                image = getAttack()[0];
                break;
        }

        if(!direction.equals("attack")){
            g2.drawImage(image, getX(), getY(), tileSize,tileSize,null);
            direction = "down";
        }
        else{
            g2.drawImage(image, getX(), getY(), tileSize,tileSize,null);
        }

    }

    public void update(){

        if(keyH.isUp() || keyH.isDown() || keyH.isLeft() || keyH.isRight() || keyH.isAttack()) {

            if (keyH.isUp()) {
                direction = "up";
            }
            if (keyH.isDown()) {
                direction = "down";
            }
            if (keyH.isLeft()) {
                direction = "left";
            }
            if (keyH.isRight()) {
                direction = "right";
            }
            if(keyH.isAttack()){
                direction = "attack";
            }

            colliding();

            spriteCounter++;
            if (spriteCounter > 10) {
                spriteNum = (spriteNum + 1) % 4;
                spriteCounter = 0;
            }
        }

        doDamage();
        receiveDamage();
    }

    public void receiveDamage(){
        timeCounter++;
        if(abs(enemy.getX() - getX()) < 5  &&  abs(enemy.getY() - getY()) < 5  &&  timeCounter >= 50){
            setHealth(getHealth() - 10);

            timeCounter = 0;
            playSE(4);

            if(getHealth() <= 0){
                gp.setGameState(2);
            }
        }
    }

    public void doDamage(){
        timeCounter2++;
        if(keyH.isAttack() && abs(enemy.getX() - getX()) < gp.getTileSize()  && abs(enemy.getY() - getY()) < gp.getTileSize() && timeCounter2 >= 20){
            enemy.setHealth(enemy.getHealth() - 5);

            playSE(2);
            timeCounter2 = 0;

            if(enemy.getHealth() <= 0){
                playSE(3);
                enemy.setAlive(false);
                score += 5;
            }
        }
    }

    public void colliding(){
        // handle collision
        setCollision(false);
        gp.getGameScreen().getCc().checkTile(this);

        // if collision is false, player can move
        if(!isCollision()) {
            switch (getDirection()){
                case "up":
                    this.setY(this.getY() - this.getSpeed());
                    break;
                case "down":
                    this.setY(this.getY() + this.getSpeed());
                    break;
                case "left":
                    this.setX(this.getX() - this.getSpeed());
                    break;
                case "right":
                    this.setX(this.getX() + this.getSpeed());
                    break;
            }
        }
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

    // getter & setter
    public void getEnemy(Enemy enemy){
        this.enemy = enemy;
    }

    public int getScore() {
        return score;
    }
}
