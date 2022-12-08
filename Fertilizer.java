

public class Fertilizer extends Tool {

    public Fertilizer() {
        super("Fertilizer", 10, 4);
    }

    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        if (player.getObjectcoin() >= getUsageCost()) {
            if (tile.getSeed() != null) {

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
