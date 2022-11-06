/**
 * This class represents the farmer's experience, which contains the player
 * experience and the player level.
 */
public class FarmerExp {
    private double playerExp;
    private int playerLevel;


    /**
     * Creates a FarmerExp object
     */
    public FarmerExp() {
        this.playerExp = 0;
        this.playerLevel = 0;
    }

    /**
     * A method that updates the experience of the player upon action that
     * results to experience yield. The action might be plowing a tile, watering
     * a seed, or harvesting a crop.
     *
     * @param expYield  the experience yield
     */
    public void updatePlayerExp(double expYield) {
        this.playerExp += expYield;
        playerLevel = (int)(playerExp / 100);
    }

    /**
     * A method that returns the player's experience
     *
     * @return the player's experience
     */
    public double getPlayerExp() {
        return playerExp;
    }

    /**
     * A method that returns the player's level
     *
     * @return the player's level
     */
    public int getPlayerLevel() {
        return playerLevel;
    }
}
