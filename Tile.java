
import java.util.ArrayList;
import java.util.List;


public class Tile {
        private int dayPlanted;
        private int tileNumber;
        private boolean isPlowed;
        private boolean isWithered;
        private boolean hasRocks;
        private int wateredCrop;
        private int fertilizedCrop;
        private Seed seed;
        /**
         * Creates a Tiles object.
         * <p>
         * The values of the attributes isWithered and isPlowed
         * are initialized to false. The myfarm.seed attribute will be
         * initialized as null. The rest are initialized to 0.
         * </p>
         */
        public Tile(int tileNumber){
            this.tileNumber = tileNumber;
            this.dayPlanted = 0;
            this.isPlowed = false;
            this.isWithered = false;
            this.hasRocks = false;
            this.wateredCrop = 0;
            this.fertilizedCrop = 0;
            this.seed = null;
        }
    /**
     * Takes myfarm.Player object, Seed object, and day integer as parameters.
     * Modifies the myfarm.seed attribute.
     * <p>
     * The method represents the 'plant myfarm.seed' action in the game.
     * It automatically deducts the objectcoins from the
     * player upon use and updates the player exp.
     * Displays text upon success or failure.
     * </p>
     *
     * @param player    the myfarm.Player object instance
     * @param plant     the myfarm.seed object instance
     * @param day       the number of days in-game
     */
    public void plantSeed(Player player, Seed plant, int day){
        int[] edges = {1,2,3,4,5,6,7,8,9,10,11,20,21,30,31,40,41,42,43,44,45,46,47,48,49,50};
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
            if(this.isPlowed) {
                boolean result = true;
                if(plant.getCropType().equals("Fruit tree")){
                    if(!List.of(edges).contains(tileNumber)){
                        for (Integer i: restrictions) {
                            if(i>=0)
                                if (farm.get(i).getSeed() != null || farm.get(i).getHasRocks() || farm.get(i).getWitherStatus()) {
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
                    System.out.println("myfarm.Player's Objectcoins is now " + player.getObjectcoin() + ".");
                } else
                    System.out.println("myfarm.Player does not have enough Objectcoins.");
            }else System.out.println("myfarm.Tile is unplowed.");
        }else System.out.println("A myfarm.seed is already planted.");

    }

    /**
     * Takes myfarm.Player object and day integer as parameters.
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
     * @param player    the myfarm.Player object instance
     * @param day       the number of days in-game
     */
    public void harvestCrop(Player player, int day){
        double HarvestTotal, FinalTotal, WaterBonus, FertBonus, produce; // local variables for computations
        if(seed!=null && !this.isWithered) { // check for wither status and if myfarm.seed is planted
            if (seed.getHarvestTime() == (day - this.dayPlanted)) {
                if (wateredCrop >= seed.getWaterNeeds()) { // check if water requirement is met
                    produce = seed.getSeedProduce();
                    HarvestTotal = produce * (seed.getSellingPrice()+player.getFarmerType().getBonusPerProduce());
                    if(wateredCrop>= (seed.getWaterBonusLimit()+player.getFarmerType().getWaterBonusLI()))
                        WaterBonus = HarvestTotal * 0.2 * (seed.getWaterBonusLimit()-1);
                    else WaterBonus = HarvestTotal * 0.2 * (wateredCrop-1);
                    if(fertilizedCrop>= (seed.getFertilizerBonusLimit()+player.getFarmerType().getFertBonusLI()))
                        FertBonus = HarvestTotal * 0.5 * (seed.getFertilizerBonusLimit());
                    else FertBonus = HarvestTotal * 0.5 * (fertilizedCrop);
                    FinalTotal = HarvestTotal + WaterBonus + FertBonus;
                    if (seed.getCropType().compareTo("Flower") == 0) // flowers get bonuses
                        FinalTotal = FinalTotal * 1.1;
                    // update objectcoins and exp
                    player.setObjectcoin(player.getObjectcoin()+FinalTotal);
                    player.updatePlayerExp(seed.getExpYield());
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

    public boolean getIsPlowed(){return this.isPlowed;}

    /**
     * Returns the wither status of the crop.
     *
     * @return  the value in attribute isWithered
     */
    public boolean getWitherStatus(){return this.isWithered;}

    public boolean getHasRocks() {
        return this.hasRocks;
    }

    /**
     * Returns the number of times the crop is watered.
     *
     * @return  the integer value in attribute wateredCrop
     */
    public int getWateredCrop(){return this.wateredCrop;}

    public int getFertilizedCrop() {
        return this.fertilizedCrop;
    }
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
    public void setHasRocks(boolean hasRocks) {
        this.hasRocks = hasRocks;
    }

    public void setWateredCrop(int wateredCrop) {
        this.wateredCrop = wateredCrop;
    }

    public void setFertilizedCrop(int fertilizedCrop) {
        this.fertilizedCrop = fertilizedCrop;
    }

}
