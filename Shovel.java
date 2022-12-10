/**
 * Shovel class represents a shovel that extends the abstract class Tool.
 * <p>
 * Shovel is primarily used to remove a crop from a tile regardless of
 * its wither status. It could also be used to tiles with no seed planted
 * but it will take no effect on the tile.
 * </p>
 */

public class Shovel extends Tool {

    /**
     * Creates a Shovel object with predefined attributes that is passed to the
     * constructor of the abstract class Tool.
     */
    public Shovel() {
        super("Shovel", 7 , 2);
    }

    /**
     * This method is used to remove a crop from a tile regardless of its
     * wither status given the player can pay the usage cost. It can also
     * be used to tiles with no crop but will only result to deducting the
     * player's objectcoins and increase in experience points.
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the action status of using the tool
     */
    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        if (player.getObjectcoin() >= getUsageCost()) {

            // removes withered crop
            if (!tile.getHasRocks()) {
                tile.setWithered(false);
                tile.removeSeed();
                tile.setIsPlowed(false);
                tile.setFertilizedCrop(0);
                tile.setWateredCrop(0);
            }

            //updating player's objectcoin + exp
            player.setObjectcoin(player.getObjectcoin() - getUsageCost());
            player.updatePlayerExp(getExpYield());

            actionStatus = true;
        }


        // if used on unplowed || with stone == lose obj coins
        return actionStatus;
    }
}
