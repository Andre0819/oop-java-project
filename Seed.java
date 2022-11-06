/*---------------------------------------------------------------------------
    This is to certify that this project is our own work, based on our own
    efforts and understanding of the concepts taught to us. The program was
    run, tested, and debugged by ourselves. We also certify that we did not
    plagiarize in part or whole the work of other people.

    Aquino & Ogatia CCPROG3-S17
 --------------------------------------------------------------------------*/

import java.util.Random;

/**
 * This class represents a seed, which contains a seed name, crop type, time it takes
 * to harvest the crop, the minimum and maximum amount of water it needs to be harvestable,
 * the number of possible produce, the seed cost, the base selling price, and its experience
 * yield.
 */
public class Seed {

    private String seedName;
    private String cropType;
    private int harvestTime;
    private int waterNeeds;
    private int waterBonusLimit;
    private int seedProduceMin;
    private int seedProduceMax;
    private int seedCost;
    private int sellingPrice;
    private float expYield;

    /**
     * Creates a Seed object by supplying the seed name, crop type, time it takes
     * to harvest the crop, the minimum and maximum amount of water and fertilizer it needs
     * to be harvestable, the number of possible produce, the seed cost, and its base selling
     * price.
     *
     * @param seedName          the name of the seed
     * @param cropType          the crop type of the seed
     * @param harvestTime       the number of days the seed needs for harvest
     * @param waterNeeds        the minimum amount of water the seed needs for harvest
     * @param waterBonusLimit   the maximum amount of water the seed can take
     * @param seedProduceMin    the minimum number of produce the seed can make
     * @param seedProduceMax    the maximum number of produce the seed can make
     * @param seedCost          the cost of the seed in objectcoin
     * @param sellingPrice      the base selling price of the seed per produce
     * @param expYield          the experience yield of the seed upon harvest
     */
    public Seed(String seedName, String cropType, int harvestTime, int waterNeeds, int waterBonusLimit,
                int seedProduceMin, int seedProduceMax, int seedCost, int sellingPrice, float expYield){

        this.seedName = seedName;
        this.cropType = cropType;
        this.harvestTime = harvestTime;
        this.waterNeeds = waterNeeds;
        this.waterBonusLimit = waterBonusLimit;
        this.seedProduceMin = seedProduceMin;
        this.seedProduceMax = seedProduceMax;
        this.seedCost = seedCost;
        this.sellingPrice = sellingPrice;
        this.expYield = expYield;
    }

    /**
     * A method that returns the seed name.
     *
     * @return the name of the seed
     */
    public String getSeedName() {
        return seedName;
    }

    /**
     * A method the returns the crop type.
     *
     * @return the crop type of the seed
     */
    public String getCropType() {
        return cropType;
    }

    /**
     * A method that returns the harvest time of the seed.
     *
     * @return the number of days the seed needs for harvest
     */
    public int getHarvestTime() {
        return harvestTime;
    }

    /**
     * A method that returns the water needs of the seed.
     *
     * @return the minimum amount of water the seed needs for harvest
     */
    public int getWaterNeeds() {
        return waterNeeds;
    }

    /**
     * A method that returns the water bonus limit of the seed.
     *
     * @return the maximum amount of water the seed can take
     */
    public int getWaterBonusLimit() {
        return waterBonusLimit;
    }

    /**
     * A method that returns the seed cost.
     *
     * @return the cost of the seed in objectcoin
     */
    public int getSeedCost() {
        return seedCost;
    }

    /**
     * A method the returns the selling price of the seed per produce.
     *
     * @return the base selling price of the seed per produce
     */
    public int getSellingPrice() {
        return sellingPrice;
    }

    /**
     * A method the returns the experience yield of the seed upon harvest
     *
     * @return the experience yield of the seed upon harvest
     */
    public float getExpYield() {
        return expYield;
    }

    /**
     * A method that generates a random number of produce given the range of
     * produce the seed can make.
     *
     * @return the number of produce the seed generated
     */
    public int getSeedProduce() {
        Random randomizer = new Random();
        return randomizer.nextInt(seedProduceMin, seedProduceMax + 1);
    }
}
