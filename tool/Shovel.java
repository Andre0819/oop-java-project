package tool;
import tile.Tile;

public class Shovel extends Tool {

    public Shovel() {
        super("Shovel", 7 , 2);
    }

    public boolean useShovel(Tile tile) {

        // removes withered crop
        if (tile.isWithered()) {
            tile.setWithered(false);
            //update playerExp
        }
        // remove seed when there is seed
        else if (tile.getSeed() != null) {
            //tile.setSeed(null) ?
        }

        // if used on unplowed || with stone == lose obj coins
        return true;
    }
}
