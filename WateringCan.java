/**
 * WateringCan class represents a watering can that extends the abstract class Tool.
 * <p>
 * Watering can is primarily used to water a tile.
 * </p>
 */
public class WateringCan extends Tool {

    /**
     * Creates a WateringCan object with predefined attributes that is passed to the
     * constructor of the abstract class Tool.
     */
    public WateringCan() {
        super("Watering Can", 0, 0.5);
    }

    /**
     * This method is used to water a tile with a crop.
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the action status of using the tool
     */
    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        // can only be performed on a tile with a myfarm.seed
        if (tile.getSeed() != null && !tile.getWitherStatus()) {

            tile.setWateredCrop(tile.getWateredCrop() + 1);

            //update player exp
            player.updatePlayerExp(this.getExpYield());
            actionStatus = true;
        }

        return actionStatus;
    }
}
