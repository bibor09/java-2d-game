package entities;

import java.awt.image.BufferedImage;

public class Entity {
    private int x, y, speed, health;
    private BufferedImage[] up, down, left, right, attack;
    public String direction;
    private boolean collision = false;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage[] getUp() {
        return up;
    }

    public void setUp(BufferedImage[] up) {
        this.up = up;
    }

    public BufferedImage[] getDown() {
        return down;
    }

    public void setDown(BufferedImage[] down) {
        this.down = down;
    }

    public BufferedImage[] getLeft() {
        return left;
    }

    public void setLeft(BufferedImage[] left) {
        this.left = left;
    }

    public BufferedImage[] getRight() {
        return right;
    }

    public void setRight(BufferedImage[] right) {
        this.right = right;
    }

    public BufferedImage[] getAttack() {
        return attack;
    }

    public void setAttack(BufferedImage[] attack) {
        this.attack = attack;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
