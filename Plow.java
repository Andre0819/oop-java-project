public class Plow extends Tool {

    public Plow() {
        super("Plow", 0, 0.5);
    }

    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        // can only be performed on unplowed tile
        if (!tile.getIsPlowed()) {

            tile.setIsPlowed(true);

            //updating player's exp after use
            player.updatePlayerExp(getExpYield());

            actionStatus = true;
        }

        return actionStatus;
    }
}
