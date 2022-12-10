/**
 * Fertilizer class represents a fertilizer that extends the abstract class Tool.
 * <p>
 * Fertilizer is primarily used to apply fertilizer to a plowed tile with a crop.
 * </p>
 */
public class Fertilizer extends Tool {

    /**
     * Creates a Fertilizer object with predefined attributes that is passed to the
     * constructor of the abstract class Tool.
     */
    public Fertilizer() {
        super("Fertilizer", 10, 4);
    }

    /**
     * This method is used to apply fertilizer to a tile with a crop
     * given that the player can pay the usage cost of the tool.
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the action status of using the tool
     */
    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        if (player.getObjectcoin() >= getUsageCost()) {
            if (tile.getSeed() != null && !tile.getWitherStatus()) {

                tile.setFertilizedCrop(tile.getFertilizedCrop() + 1);

                //updating player's objectcoin + exp
                player.setObjectcoin(player.getObjectcoin() - getUsageCost());
                player.updatePlayerExp(getExpYield());

                actionStatus = true;
            }
        }
        // can only be performed on a tile with a myfarm.seed


        return actionStatus;
    }
}
