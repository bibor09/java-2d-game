package screen;

import entities.Enemy;
import entities.Player;
import mechanics.CollisionChecker;
import mechanics.KeyHandler;
import main.GamePanel;
import ui_and_audio.Sound;
import ui_and_audio.UI;
import tiles.TileManager;


import java.awt.*;

public class GameScreen {
    private GamePanel gp;

    // Mechanics
    private KeyHandler keyH;
    private CollisionChecker cc;

    // Visual and Audio
    private Sound sound = new Sound();
    private TileManager tm;
    private UI ui;

    // Entities
    private int playerX = 100, playerY = 100, playerSpeed = 3, playerHealth = 100;
    private Player player;
    int enemySpeed = 1, enemyHealth = 60;
    private Enemy enemy;

    // Methods
    public GameScreen(GamePanel gp){
        this.gp = gp;
        initGame();
        playMusic(0);
        player.getEnemy(enemy);
        gp.addKeyListener(keyH);
    }

    public void initGame(){
        // Mechanics
        keyH = new KeyHandler(this);
        cc = new CollisionChecker(this);

        // Visual and Audio
        tm = new TileManager(gp);
        ui = new UI(this);

        // Entities
        player = new Player(playerX, playerY, playerSpeed, playerHealth,gp, keyH);
        enemy = new Enemy(gp, player, enemySpeed, enemyHealth);
    }

    public void draw(Graphics2D g2){
        tm.draw(g2);
        player.draw(g2, gp.getTileSize());
        enemy.draw(g2);
        ui.draw(g2);
    }

    public void update(){
        player.update();
        enemy.update();
    }

    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void resetGame(){
        // reset player
        player.setHealth(100);
        player.setX(100);
        player.setY(100);

        // reset enemy
        enemy.setHealth(20);
    }

    // getter & setter
    public GamePanel getGp() {
        return gp;
    }

    public void setGp(GamePanel gp) {
        this.gp = gp;
    }

    public CollisionChecker getCc() {
        return cc;
    }

    public TileManager getTm() {
        return tm;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
