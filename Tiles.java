/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

/**
 * Tiles class contains the different attributes
 * used for monitoring its status including the seed.
 */
public class Tiles {
    private int dayPlanted;
    private boolean isPlowed;
    private boolean isWithered;
    private int wateredCrop;
    private Seed seed;
    /**
     * Creates a Tiles object.
     * <p>
     * The values of the attributes isWithered and isPlowed
     * are initialized to false. The seed attribute will be
     * initialized as null. The rest are initialized to 0.
     * </p>
     */
    public Tiles(){
        this.isPlowed = false;
        this.isWithered = false;
        this.seed = null;
        this.dayPlanted = 0;
        this.wateredCrop = 0;
    }

    /**
     * Takes MyFarm object and modifies the isPlowed attribute.
     * <p>
     * The method represents the 'plow' action in the game.
     * It automatically deducts the objectcoins from the
     * player upon use and updates the player exp.
     * Displays text upon success or failure.
     * </p>
     *
     * @param farm  the MyFarm object instance
     */
    public void plowTile(MyFarm farm){
        Player p = farm.getPlayer();
        if(!this.isPlowed){
            // update objectcoins, exp, and plow status
            this.isPlowed = true;
            p.setObjectcoin(p.getObjectcoin()-farm.getTools().get(0).getUsageCost());
            p.getFarmerExp().updatePlayerExp(farm.getTools().get(0).getExpYield());
            System.out.println("Tile is now plowed.");
        } else
            System.out.println("Tile has already been plowed.");
    }
    /**
     * Takes MyFarm object and modifies the wateredCrop attribute.
     * <p>
     * The method represents the 'water crop' action in the game.
     * It automatically deducts the objectcoins from the
     * player upon use and updates the player exp.
     * Displays text upon success or failure.
     * </p>
     *
     * @param farm  the MyFarm object instance
     */
    public void waterCrop(MyFarm farm){
        Player p = farm.getPlayer();
        if(this.seed != null) {
            // update exp
            p.getFarmerExp().updatePlayerExp(farm.getTools().get(1).getExpYield());
            this.wateredCrop++;
            System.out.println("This crop has been watered " + this.wateredCrop + " times.");
        }
        else
            System.out.println("The tile is currently empty.");
    }
    /**
     * Takes Player object, Seed object, and day integer as parameters.
     * Modifies the seed attribute.
     * <p>
     * The method represents the 'plant seed' action in the game.
     * It automatically deducts the objectcoins from the
     * player upon use and updates the player exp.
     * Displays text upon success or failure.
     * </p>
     *
     * @param player    the Player object instance
     * @param plant     the seed object instance
     * @param day       the number of days in-game
     */
    public void plantSeed(Player player, Seed plant, int day){
        if(seed==null) {
            if(this.isPlowed) {
                if (player.getObjectcoin() > plant.getSeedCost()) {
                    // update objectcoins, seed, dayPlanted
                    player.setObjectcoin(player.getObjectcoin() - plant.getSeedCost());
                    this.seed = plant;
                    this.dayPlanted = day;
                    System.out.println(plant.getSeedName() + " successfully planted.");
                    System.out.println("Player's Objectcoins is now " + player.getObjectcoin() + ".");
                } else
                    System.out.println("Player does not have enough Objectcoins.");
            }else System.out.println("Tile is unplowed.");
        }else System.out.println("A seed is already planted.");

    }
    /**
     * Takes Player object and day integer as parameters.
     * Able to modify all class attributes.
     * <p>
     * The method represents the 'harvest crop' action in the game.
     * It automatically computes for the final total after selling
     * considering the bonuses available. It adds the objectcoins
     * (from selling) to the player upon use and updates the player exp.
     * Also automatically checks and updates for when a 'crop' withers.
     * Displays text upon success or failure.
     * </p>
     *
     * @param player    the Player object instance
     * @param day       the number of days in-game
     */
    public void harvestCrop(Player player, int day){
        double HarvestTotal, FinalTotal, WaterBonus, produce; // local variables for computations
        if(seed!=null && !this.isWithered) { // check for wither status and if seed is planted
            if (seed.getHarvestTime() == (day - this.dayPlanted)) {
                if (wateredCrop >= seed.getWaterNeeds()) { // check if water requirement is met
                    produce = seed.getSeedProduce();
                    HarvestTotal = produce * (seed.getSellingPrice());
                    if(wateredCrop>= seed.getWaterBonusLimit())
                        WaterBonus = HarvestTotal * 0.2 * (seed.getWaterBonusLimit()-1);
                    else WaterBonus = HarvestTotal * 0.2 * (wateredCrop-1);
                    FinalTotal = HarvestTotal + WaterBonus;
                    if (seed.getCropType().compareTo("Flower") == 0) // flowers get bonuses
                        FinalTotal = FinalTotal * 1.1;
                    // update objectcoins and exp
                    player.setObjectcoin(player.getObjectcoin()+FinalTotal);
                    player.getFarmerExp().updatePlayerExp(seed.getExpYield());
                    // reset attribute values
                    this.wateredCrop = 0;
                    this.seed = null;
                    this.isPlowed = false;
                    System.out.println("Crop successfully harvested.\nProducts produced: " + produce);
                } else {
                    // set wither status to true
                    this.isWithered = true;
                    System.out.println("Crop did not meet the water requirement.\nCrop has withered.");
                }
            } else
                System.out.println("The crop is not yet ready for harvest.");
        }

    }
    /**
     * Returns the seed and its corresponding attributes.
     *
     * @return  the value in attribute seed
     */
    public Seed getSeed(){return this.seed;}
    /**
     * Returns the number of days since the seed was planted.
     *
     * @return  the value in attribute dayPlanted
     */
    public int getDayPlanted(){return this.dayPlanted;}
    /**
     * Returns the wither status of the crop.
     *
     * @return  the value in attribute isWithered
     */
    public boolean getWitherStatus(){return this.isWithered;}
    /**
     * Returns the number of times the crop is watered.
     *
     * @return  the integer value in attribute wateredCrop
     */
    public int getWateredCrop(){return this.wateredCrop;}
    /**
     * Takes boolean status as a parameter and assigns it
     * to attribute isWithered.
     * <p>
     * This is used in multiple methods from different classes.
     * There is no single description for the parameter status.
     * </p>
     *
     * @param status    a boolean value representing the wither
     *                  status of a crop
     */
    public void setWithered(boolean status){
        this.isWithered = status;
    }
}
