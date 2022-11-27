package tool;
import tile.Tile;

public class Plow extends Tool {

    public Plow() {
        super("Plow", 0, 0.5);
    }

    public boolean plowTile(Tile tile) {

        boolean actionStatus = false;

        // can only be performed on unplowed tile
        if (!tile.isPlowed()) {
            tile.setPlowed(true);
            //update the exp ng player
            actionStatus = true;
        }

        return actionStatus;
    }
}
