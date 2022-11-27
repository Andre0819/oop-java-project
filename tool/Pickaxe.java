package tool;
import tile.Tile;


public class Pickaxe extends Tool {

    public Pickaxe() {
        super("Pickaxe", 50, 15);
    }

    public boolean usePickaxe(Tile tile) {

        boolean actionStatus = false;

        // can only be performed on tile with rock
        if (tile.hasRocks()) {
            tile.setHasRocks(false);
            //update player exp
            actionStatus = true;
        }

        return actionStatus;
    }
}
