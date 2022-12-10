/**
 * Pickaxe class represents a pickaxe that extends the abstract class Tool.
 * <p>
 * Pickaxe is primarily used to remove a rock from a tile.
 * </p>
 */
public class Pickaxe extends Tool {

    /**
     * Creates a Pickaxe object with predefined attributes that is passed to the
     * constructor of the abstract class Tool.
     */
    public Pickaxe() {
        super("Pickaxe", 50, 15);
    }

    /**
     * This method is used to remove the rock from a tile given that the player
     * can pay the usage cost of the tool
     *
     * @param tile      the tile where tool will be used on
     * @param player    the player using the tool
     *
     * @return the action status of using the tool
     */
    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;


        if (player.getObjectcoin() >= getUsageCost()) {

            // can only be performed on tile with rock
            if (tile.getHasRocks()) {

                tile.setHasRocks(false);

                //updating player's objectcoin + exp
                player.setObjectcoin(player.getObjectcoin() - getUsageCost());
                player.updatePlayerExp(getExpYield());

                actionStatus = true;
            }
        }

        return actionStatus;
    }
}
