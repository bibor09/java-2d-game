package mechanics;

import entities.Entity;
import screen.GameScreen;

public class CollisionChecker {
    private GameScreen gs;

    public CollisionChecker(GameScreen gs){
        this.gs = gs;
    }

    public void checkTile(Entity entity){
        // entity tile 4 coordinates
        int tileSize = gs.getGp().getTileSize();

        int leftX = entity.getX();
        int rightX = leftX + tileSize;
        int topY = entity.getY();
        int botY = topY + tileSize;

        int leftCol = leftX/tileSize;
        int rightCol = rightX/tileSize;
        int botRow = botY/tileSize;
        int topRow = topY/tileSize;

        int tileNum1 = 0, tileNum2 = 0;

        switch(entity.direction){
            case "up":
                topRow = (topY - entity.getSpeed())/tileSize;
                tileNum1 = gs.getTm().getMapTile()[topRow][leftCol];
                tileNum2 = gs.getTm().getMapTile()[topRow][rightCol];
                break;
            case "down":
                botRow = (botY - entity.getSpeed())/tileSize;
                tileNum1 = gs.getTm().getMapTile()[botRow][leftCol];
                tileNum2 = gs.getTm().getMapTile()[botRow][rightCol];
                break;
            case "left":
                leftCol = (leftX - entity.getSpeed())/tileSize;
                tileNum1 = gs.getTm().getMapTile()[topRow][leftCol];
                tileNum2 = gs.getTm().getMapTile()[botRow][leftCol];
                break;
            case "right":
                rightCol = (rightX - entity.getSpeed())/tileSize;
                tileNum1 = gs.getTm().getMapTile()[topRow][rightCol];
                tileNum2 = gs.getTm().getMapTile()[botRow][rightCol];
                break;
        }
        if(gs.getTm().getTile()[tileNum1].collision ||gs.getTm().getTile()[tileNum2].collision){
            entity.setCollision(true);
        }
    }
}
