/**
 * Plow class represents a plow that extends the abstract class Tool.
 * <p>
 * Plow is primarily used to convert an unplowed tile to a plowed tile.
 * </p>
 */
public class Plow extends Tool {

    /**
     * Creates a Plow object with predefined attributes that is passed to the
     * constructor of the abstract class Tool.
     */
    public Plow() {
        super("Plow", 0, 0.5);
    }

    /**
     * This method is used to convert an unplowed tile to a plowed tile.
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the action status of using the tool
     */
    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        // can only be performed on unplowed tile
        if (!tile.getIsPlowed() && !tile.getHasRocks()) {

            tile.setIsPlowed(true);

            //updating player's exp after use
            player.updatePlayerExp(getExpYield());

            actionStatus = true;
        }

        return actionStatus;
    }
}
