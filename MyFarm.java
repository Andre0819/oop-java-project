/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

import java.util.ArrayList;

/**
 * MyFarm class contains the player, tools, and seeds
 * that will be used throughout the program as well as
 * keeps track of the in-game days.
 */
public class MyFarm {
    private int day;
    private Player player;
    private ArrayList<Tools> tools;
    private ArrayList<Seed> seeds;

    /**
     * Creates a MyFarm object containing the
     * attributes: day, player, tools, and seeds.
     * <p>
     * Two Tools objects are added to the ArrayList tools
     * and a Seed object is added to the ArrayList seeds.
     * </p>
     */
    public MyFarm(){
        this.day = 1;
        this.player = new Player();

        // add plow, watering can
        this.tools = new ArrayList<>();
        tools.add(new Tools("Plow", 0, 0.5));
        tools.add(new Tools("Watering Can", 0, 0.5));
        // add turnip
        this.seeds = new ArrayList<>();
        seeds.add(new Seed("Turnip", "Root crop", 2, 1, 2, 1, 2, 5, 6, 5));
    }

    /**
     * Updates the day in-game and modifies the isWithered
     * attribute of the Tiles object.
     * <p>
     * The method checks for when conditions are met to modify
     * the isWithered attribute of a Tiles object.
     * Displays text corresponding to the case met.
     * </p>
     */
    public void advanceNextDay(){
        this.day++;
        if(player.getFarmLot().getSeed()!=null) {
            //checks if the crop harvest time is <,>, or == to the # of days that has passed since being planted
            if (player.getFarmLot().getSeed().getHarvestTime() < (day - player.getFarmLot().getDayPlanted())) {
                System.out.println("The crop has withered.");
                player.getFarmLot().setWithered(true);
            } else if (player.getFarmLot().getSeed().getHarvestTime() == (day - player.getFarmLot().getDayPlanted())) {
                System.out.println("The crop is now available for harvest.");
            }
        }

    }

    /**
     * Returns a boolean value after checking if the
     * game has ended as per the conditions provided.
     *
     * @return  true if all conditions are met; otherwise false
     */
    public boolean checkGameEnd(){
        boolean activeCrop = false;
        if(player.getFarmLot().getSeed() != null) { //checks if the tile currently has a seed.
                activeCrop = true;
        }

        return (player.getObjectcoin() < 5 && activeCrop) || player.getFarmLot().getWitherStatus();
    }

    /**
     * Returns the number of days passed in-game.
     *
     * @return  the integer value of attribute day
     */
    public int getDay(){return this.day;}
    /**
     * Returns the Player object stored in player.
     *
     * @return  player as a Player object
     */
    public Player getPlayer(){return this.player;}

    /**
     * Returns a list of tools available in the game.
     *
     * @return  Tools objects in tools
     */
    public ArrayList<Tools> getTools(){return this.tools;}
    /**
     * Returns a list of seeds available in the game.
     *
     * @return  Seed objects in seeds
     */
    public ArrayList<Seed> getSeeds(){return this.seeds;}
}
