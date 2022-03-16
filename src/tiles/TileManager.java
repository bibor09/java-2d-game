package tiles;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class TileManager {
    private GamePanel gp;
    private int numberOfTiles = 4;
    private Tile[] tile;                            // all the tiles for the game
    private int mapTile[][];                        // the txt format map

    public TileManager(GamePanel gp){
        this.gp = gp;
        tile = new Tile[numberOfTiles];
        mapTile = new int[gp.getScreenRow()][gp.getScreenCol()];
        readMap();
        getTileImage();
    }

    public void readMap(){
        File inputFile = new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\map.txt");
        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            for(int row = 0; row < gp.getScreenRow(); row++){
                try {

                    String line = br.readLine();                                // read a line ex. 0 0 1 0 ...
                    String number[] = line.split(" ");                    // split it in an array
                    for(int col = 0; col < gp.getScreenCol(); col++){
                        mapTile[row][col] = Integer.parseInt(number[col]);      // make char->int
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTileImage(){
        for(int i=0; i<numberOfTiles; i++){
            tile[i] = new Tile();
            try {
                tile[i].image = ImageIO.read(new File("D:\\Egyetem\\III.FELEV\\JavaProjekt\\MyGame\\Assets\\Tiles\\floor_" + i + ".png"));
                if(i == 3) tile[i].collision = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2){
        int x,y;

        for(int row = 0; row < gp.getScreenRow(); row++){
            y = row * gp.getTileSize();
            for(int col = 0; col < gp.getScreenCol(); col++){
                x = col * gp.getTileSize();
                int tileNum = mapTile[row][col];
                g2.drawImage(tile[tileNum].image,x,y,gp.getTileSize(),gp.getTileSize(),null);
            }
        }
    }

    // getters
    public int[][] getMapTile() {
        return mapTile;
    }

    public Tile[] getTile() {
        return tile;
    }
}
