
public class Shovel extends Tool {

    public Shovel() {
        super("Shovel", 7 , 2);
    }

    public boolean useTool(Tile tile, Player player) {

        boolean actionStatus = false;

        if (player.getObjectcoin() >= getUsageCost()) {

            // removes withered crop
            if (tile.getWitherStatus()) {
                tile.setWithered(false);
            }

            // remove myfarm.seed when there is myfarm.seed
            else if (tile.getSeed() != null) {
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
