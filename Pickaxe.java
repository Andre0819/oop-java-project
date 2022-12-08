

public class Pickaxe extends Tool {

    public Pickaxe() {
        super("Pickaxe", 50, 15);
    }

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
