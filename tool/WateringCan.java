package tool;
import tile.Tile;

public class WateringCan extends Tool {

    public WateringCan() {
        super("Watering Can", 0, 0.5);
    }

    public boolean waterTile(Tile tile) {

        boolean actionStatus = false;

        // can only be performed on a tile with a seed
        if (tile.getSeed() != null) {
            tile.setWateredCrop(tile.getWateredCrop() + 1);
            //update player exp
            actionStatus = true;
        }

        return actionStatus;
    }
}
