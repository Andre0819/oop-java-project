/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

/**
 * Player class contains the farmLot, objectcoin,
 * and farmerExp attributes. Most methods from
 * other classes will be accessing Player to obtain
 * or update values in its attributes.
 */
public class Player {
    private final Tiles farmLot;
    private double objectcoin;
    private final FarmerExp farmerExp;
    /**
     * Creates a Player object.
     * <p>
     * The values of the attribute objectcoin is
     * initialized to 100. The attributes farmLot and
     * farmerExp are initialized with instantiated objects
     * Tiles and FarmerExp respectively.
     * </p>
     */
    public Player(){
        this.farmLot = new Tiles();
        this.objectcoin = 100;
        this.farmerExp = new FarmerExp();
    }
    /**
     * Returns the farmLot tile as a Tiles object.
     *
     * @return  the Tiles object farmLot
     */
    public Tiles getFarmLot(){return this.farmLot;}
    /**
     * Returns the amount of objectcoins the player currently has.
     *
     * @return  the integer value of the attribute objectcoin
     */
    public double getObjectcoin(){return this.objectcoin;}
    /**
     * Returns the exp details of the player as a FarmerExp object.
     *
     * @return  the FarmerExp object in farmerExp
     */
    public FarmerExp getFarmerExp(){return this.farmerExp;}

    /**
     * Takes parameter coin and updates the attribute objectcoin
     * with coin as its new value.
     *
     * @param coin  the new amount of objectcoins in double format
     */
    public void setObjectcoin(double coin){this.objectcoin = coin;}
}
