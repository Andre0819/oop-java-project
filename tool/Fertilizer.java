package tool;
import tile.Tile;

public class Fertilizer extends Tool {

    public Fertilizer() {
        super("Fertilizer", 10, 4);
    }

    public boolean fertilizeTile(Tile tile) {

        boolean actionStatus = false;

        // can only be performed on a tile with a seed
        if (tile.getSeed() != null) {
            tile.setFertilizedCrop(tile.getFertilizedCrop() + 1);
            //update player exp
            actionStatus = true;
        }

        return actionStatus;
    }
}
