/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

/**
 * This class represents the farmer's experience, which contains the player
 * experience and the player level.
 */
public class FarmerExp {
    private double playerExp;
    private int playerLevel;


    /**
     * Creates a FarmerExp object with the attributes'
     * values initialized to 0.
     */
    public FarmerExp() {
        this.playerExp = 0;
        this.playerLevel = 0;
    }

    /**
     * A method that updates the experience of the player upon action that
     * results to experience. The action might be plowing a tile, watering
     * a seed, or harvesting a crop.
     * <p>
     * The method is also responsible for automatically updating the level
     * for every 100 experience points reached.
     * </p>
     *
     * @param expYield  the experience yield
     */
    public void updatePlayerExp(double expYield) {
        this.playerExp += expYield;
        this.playerLevel = (int)(this.playerExp / 100);
    }

    /**
     * A method that returns the player's experience
     *
     * @return the player's experience
     */
    public double getPlayerExp() {
        return this.playerExp;
    }

    /**
     * A method that returns the player's level
     *
     * @return the player's level
     */
    public int getPlayerLevel() {
        return this.playerLevel;
    }
}
