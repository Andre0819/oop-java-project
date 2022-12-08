

public class WateringCan extends Tool {

    public WateringCan() {
        super("Watering Can", 0, 0.5);
    }

    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        // can only be performed on a tile with a myfarm.seed
        if (tile.getSeed() != null) {

            tile.setWateredCrop(tile.getWateredCrop() + 1);

            //update player exp
            player.updatePlayerExp(this.getExpYield());
            actionStatus = true;
        }

        return actionStatus;
    }
}
