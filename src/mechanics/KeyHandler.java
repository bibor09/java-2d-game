package mechanics;

import main.GamePanel;
import screen.GameScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gp;
    private GameScreen gs;
    private boolean up, down, left, right, attack;

    public KeyHandler(GameScreen gs){
        this.gp = gs.getGp();
        this.gs = gs;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int eventKeyCode = e.getKeyCode();

        if(gp.getGameState() == 0){
            if(eventKeyCode == KeyEvent.VK_ENTER) {
                gp.setGameState(1);
                gs.resetGame();
            }
        }
        if(gp.getGameState() == 2){
            if(eventKeyCode == KeyEvent.VK_ENTER){
                gp.setGameState(0);
            }
        }
        if(gp.getGameState() == 1) {
            switch (eventKeyCode) {
                case KeyEvent.VK_W:
                    up = true;
                    break;
                case KeyEvent.VK_S:
                    down = true;
                    break;
                case KeyEvent.VK_A:
                    left = true;
                    break;
                case KeyEvent.VK_D:
                    right = true;
                    break;
                case KeyEvent.VK_ENTER:
                    attack = true;
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int eventKeyCode = e.getKeyCode();

        if(gp.getGameState() == 1) {
            switch (eventKeyCode) {
                case KeyEvent.VK_W:
                    up = false;
                    break;
                case KeyEvent.VK_S:
                    down = false;
                    break;
                case KeyEvent.VK_A:
                    left = false;
                    break;
                case KeyEvent.VK_D:
                    right = false;
                    break;
                case KeyEvent.VK_ENTER:
                    attack = false;
                    break;
            }
        }
    }

    // getter & setter
    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isAttack() {
        return attack;
    }
}
