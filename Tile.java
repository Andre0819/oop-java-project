
import java.util.ArrayList;
import java.util.Arrays;


public class Tile {
        private int dayPlanted;
        private int tileNumber;
        private boolean isPlowed;
        private boolean isWithered;
        private boolean hasRocks;
        private int wateredCrop;
        private int fertilizedCrop;
        private int harvestProduce;
        private double finalTotal;
        private Seed seed;
        /**
         * Creates a Tiles object.
         * <p>
         * The values of the attributes isWithered and isPlowed
         * are initialized to false. The seed attribute will be
         * initialized as null. The rest are initialized to 0.
         * The Tile object will also have a tileNumber which is assigned with the parameter.
         * </p>
         *
         * @param tileNumber integer value
         */
        public Tile(int tileNumber){
            this.tileNumber = tileNumber;
            this.dayPlanted = 0;
            this.isPlowed = false;
            this.isWithered = false;
            this.hasRocks = false;
            this.wateredCrop = 0;
            this.fertilizedCrop = 0;
            this.harvestProduce = 0;
            this.finalTotal = 0;
            this.seed = null;
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
     * @param plant     the Seed object instance
     * @param day       the number of days in-game
     */
    public void plantSeed(Player player, Seed plant, int day){
        Integer[] edges = {1,2,3,4,5,6,7,8,9,10,11,20,21,30,31,40,41,42,43,44,45,46,47,48,49,50};
        ArrayList<Tile> farm = player.getFarmLot();

        ArrayList<Integer> restrictions= new ArrayList<>(){{
            add(tileNumber+1);
            add(tileNumber-1);
            add(tileNumber+9);
            add(tileNumber-9);
            add(tileNumber+10);
            add(tileNumber-10);
            add(tileNumber+11);
            add(tileNumber-11);
        }};

        if(seed==null) {
            if(this.isPlowed && !this.getHasRocks() && !this.getWitherStatus()) {
                boolean result = true;
                if(plant.getCropType().equals("Fruit tree")){
                    if(!Arrays.asList(edges).contains(tileNumber)){
                        for (Integer i: restrictions) {
                            if(i<=50 && i>=0)
                                if (farm.get(i-1).getSeed() != null || farm.get(i-1).getHasRocks() || farm.get(i-1).getWitherStatus()) {
                                    result = false;
                                    break;
                                }
                        }
                    } else result = false;
                }
                if (player.getObjectcoin() >= plant.getSeedCost() && result) {
                    // update objectcoins, myfarm.seed, dayPlanted
                    player.setObjectcoin(player.getObjectcoin() - (plant.getSeedCost()-player.getFarmerType().getCostReduction()));
                    this.seed = plant;
                    this.dayPlanted = day;
                    System.out.println(plant.getSeedName() + " successfully planted.");
                    System.out.println("Player's Objectcoins is now " + player.getObjectcoin() + ".");
                } else
                    System.out.println("Player does not have enough Objectcoins.");
            }else System.out.println("Seed cannot be planted on this tile.");
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
        double HarvestTotal, finalTotal, WaterBonus, FertBonus; // local variables for computations
        if(seed!=null && !this.isWithered) { // check for wither status and if myfarm.seed is planted
            if (seed.getHarvestTime() == (day - this.dayPlanted)) {
                if (wateredCrop >= seed.getWaterNeeds() && fertilizedCrop >= seed.getFertilizerNeeds()) { // check if water requirement is met
                    harvestProduce = seed.getSeedProduce();
                    HarvestTotal = harvestProduce * (seed.getSellingPrice()+player.getFarmerType().getBonusPerProduce());
                    if(wateredCrop>= (seed.getWaterBonusLimit()+player.getFarmerType().getWaterBonusLI()))
                        WaterBonus = HarvestTotal * 0.2 * (seed.getWaterBonusLimit()-1);
                    else WaterBonus = HarvestTotal * 0.2 * (wateredCrop-1);
                    if(fertilizedCrop>= (seed.getFertilizerBonusLimit()+player.getFarmerType().getFertBonusLI()))
                        FertBonus = HarvestTotal * 0.5 * (seed.getFertilizerBonusLimit());
                    else FertBonus = HarvestTotal * 0.5 * (fertilizedCrop);
                    this.finalTotal = HarvestTotal + WaterBonus + FertBonus;
                    if (seed.getCropType().compareTo("Flower") == 0) // flowers get bonuses
                        this.finalTotal = this.finalTotal * 1.1;
                    // update objectcoins and exp
                    player.setObjectcoin(player.getObjectcoin()+this.finalTotal);
                    player.updatePlayerExp(seed.getExpYield());
                    // reset attribute values
                    this.wateredCrop = 0;
                    this.fertilizedCrop = 0;
                    this.seed = null;
                    this.isPlowed = false;
                } else {
                    // set wither status to true
                    this.isWithered = true;
                }
            }
        }

    }
    /**
     * Sets the value of seed for this object to null.
     */
    public void removeSeed(){
        this.seed = null;
    }

    /**
     * Returns the myfarm.seed and its corresponding attributes.
     *
     * @return  the value in attribute myfarm.seed
     */
    public Seed getSeed(){return this.seed;}
    /**
     * Returns the number of days since the myfarm.seed was planted.
     *
     * @return  the value in attribute dayPlanted
     */
    public int getDayPlanted(){return this.dayPlanted;}

    /**
     * Returns the plow status of the crop
     *
     * @return the value in attribute isPlowed
     */
    public boolean getIsPlowed(){return this.isPlowed;}

    /**
     * Returns the wither status of the crop
     *
     * @return  the value in attribute isWithered
     */
    public boolean getWitherStatus(){return this.isWithered;}

    /**
     * Returns the rock status of the tile
     *
     * @return the value in attribute hasRocks
     */
    public boolean getHasRocks() {
        return this.hasRocks;
    }

    /**
     * Returns the number of times the crop is watered.
     *
     * @return  the integer value in attribute wateredCrop
     */
    public int getWateredCrop(){return this.wateredCrop;}
    /**
     * Returns the number of times the crop is fertilized.
     *
     * @return  the integer value in attribute fertilizedCrop
     */
    public int getFertilizedCrop() {
        return this.fertilizedCrop;
    }

    /**
     * Returns the number of produce from harvesting.
     *
     * @return  the integer value in attribute harvestProduce
     */
    public int getHarvestProduce() {
        return harvestProduce;
    }

    /**
     * Returns the number of produce from finalTotal.
     *
     * @return  the integer value in attribute finalTotal
     */
    public double getFinalTotal() {
        return finalTotal;
    }
    /**
     * Takes boolean status as a parameter and assigns it
     * to attribute IsPlowed.
     * <p>
     * This is used in multiple methods from different classes.
     * There is no single description for the parameter status.
     * </p>
     *
     * @param plowed    a boolean value representing the plow status
     */
    public void setIsPlowed(boolean plowed) {
        this.isPlowed = plowed;
    }
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

    /**
     * This method sets the rock status of the tile
     *
     * @param hasRocks  a boolean value representing the boolean s
     *                  status of a crop
     */
    public void setHasRocks(boolean hasRocks) {
        this.hasRocks = hasRocks;
    }

    /**
     * This method set the number of times the crop is watered
     *
     * @param wateredCrop the number of times the crop is watered
     */
    public void setWateredCrop(int wateredCrop) {
        this.wateredCrop = wateredCrop;
    }

    /**
     * This method sets the number of times the crop is fertilized
     *
     * @param fertilizedCrop    the number of times the crop is fertilized
     */
    public void setFertilizedCrop(int fertilizedCrop) {
        this.fertilizedCrop = fertilizedCrop;
    }

    /**
     * This method sets the value of harvest produce
     *
     * @param harvestProduce    the harvest produce
     */
    public void setHarvestProduce(int harvestProduce) {
        this.harvestProduce = harvestProduce;
    }

    /**
     * This method sets the final total
     *
     * @param finalTotal the final total
     */
    public void setFinalTotal(double finalTotal) {
        this.finalTotal = finalTotal;
    }
}
